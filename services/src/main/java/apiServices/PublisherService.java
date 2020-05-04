package apiServices;

import entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorys.PublisherRepository;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public void addPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void removePublisher(Publisher publisher){
        publisherRepository.delete(publisher);
    }

    public Publisher getPublisher(int id){
        return publisherRepository.findById(id).get();
    }

    public boolean publisherExists(Publisher publisher){
        return publisherRepository.existsById(publisher.getPublisherID());
    }
}
