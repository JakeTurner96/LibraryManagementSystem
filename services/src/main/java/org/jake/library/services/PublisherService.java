package org.jake.library.services;

import lombok.RequiredArgsConstructor;
import org.jake.exceptions.PublisherNotFoundException;
import org.jake.library.entities.Publisher;
import org.jake.library.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public void addPublisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public void removePublisher(int publisherId) {
        if(!publisherRepository.existsById(publisherId)){
            throw new PublisherNotFoundException("A publisher with ID " + publisherId + " could not be found");
        }else{
            publisherRepository.deleteById(publisherId);
        }
    }

    public Publisher getPublisher(int publisherId) {
        if(!publisherRepository.existsById(publisherId)){
            throw new PublisherNotFoundException("A publisher with ID " + publisherId + " could not be found");
        }else{
            return publisherRepository.findById(publisherId).get();
        }
    }

    public List<Publisher> getPublisherList() {
        return publisherRepository.findAll();
    }
}
