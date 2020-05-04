package apiServices;

import entities.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorys.PatronRepository;

@Service
public class PatronService {

    @Autowired
    private PatronRepository patronRepository;

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
        return patronRepository.existsById(patron.getPatronID());
    }

}
