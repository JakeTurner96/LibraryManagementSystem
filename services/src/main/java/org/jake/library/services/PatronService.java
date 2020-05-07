package org.jake.library.services;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.Patron;
import org.jake.library.repositories.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatronService {

    private final PatronRepository patronRepository;

    public void addPatron(Patron patron){
        patronRepository.save(patron);
    }

    public List<Patron> getPatronList(){
        return patronRepository.findAll();
    }

    public void removePatron(int id){
        patronRepository.deleteById(id);
    }

    public Patron getPatron(int id){
        return patronRepository.findById(id).get();
    }

    public boolean patronExists(Patron patron){
        return patronRepository.existsById(patron.getId());
    }

}
