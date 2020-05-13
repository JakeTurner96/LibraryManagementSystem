package org.jake.library.services;

import lombok.RequiredArgsConstructor;
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

    public void removePublisher(int id) {
        publisherRepository.deleteById(id);
    }

    public Publisher getPublisher(int id) {
        return publisherRepository.findById(id).get();
    }

    public List<Publisher> getPublisherList() {
        return publisherRepository.findAll();
    }

    public boolean publisherExists(Publisher publisher) {
        return publisherRepository.existsById(publisher.getId());
    }
}
