package org.jake.library.services;

import lombok.RequiredArgsConstructor;
import org.jake.exceptions.PatronNotFoundException;
import org.jake.library.entities.Patron;
import org.jake.library.repositories.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatronService {

    private final PatronRepository patronRepository;

    public void addPatron(Patron patron) {
        patronRepository.save(patron);
    }

    public Patron getPatron(int patronId) {
        if (!patronRepository.existsById(patronId)) {
            throw new PatronNotFoundException("A patron with ID " + patronId + " could not be found");
        } else {
            return patronRepository.findById(patronId).get();
        }
    }

    public List<Patron> getPatronList() {
        return patronRepository.findAll();
    }

    public void removePatron(int patronId) {
        if (!patronRepository.existsById(patronId)) {
            throw new PatronNotFoundException("A patron with ID " + patronId + " could not be found");
        } else {
            patronRepository.deleteById(patronId);
        }
    }
}
