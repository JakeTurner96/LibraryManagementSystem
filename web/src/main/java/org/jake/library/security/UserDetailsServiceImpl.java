package org.jake.library.security;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.Patron;
import org.jake.library.repositories.PatronRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PatronRepository repository;
    static final String ROLE_PATRON = "PATRON";
    static final String ROLE_ADMIN = "ADMIN";
    static final String ROLE_LIBRARIAN = "LIBRARIAN";

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Patron patron = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email " + email + " Does not exist in the system..."));
        return User
                .withUsername(patron.getEmail())
                .password(patron.getPassword())
                .roles(createRoles(patron.getPatronType())).build();
    }

    private String createRoles(Patron.PatronType patronType) {
        String role;
        switch (patronType) {
            case PATRON:
                role = ROLE_PATRON;
                break;
            case LIBRARIAN:
                role = ROLE_LIBRARIAN;
                break;
            case ADMIN:
                role = ROLE_ADMIN;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + patronType);
        }
        return role;
    }
}
