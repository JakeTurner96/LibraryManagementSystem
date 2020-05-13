package org.jake.library.repositories;

import org.jake.library.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatronRepository extends JpaRepository<Patron, Integer> {

    Optional<Patron> findByEmail(String email);
}
