package org.jake.library.services;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.Patron;
import org.jake.library.repositories.PatronRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatronService {

    private final PatronRepository patronRepository;

    public void addPatron(Patron patron){
        patronRepository.save(patron);
    }

    public void removePatron(Patron patron){
        patronRepository.delete(patron);
    }

    public Patron getPatron(int id){
        return patronRepository.findById(id).get();
    }

    public boolean patronExists(Patron patron){
        return patronRepository.existsById(patron.getId());
    }

}
