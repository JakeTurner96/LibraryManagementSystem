package org.jake.library.services;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.Author;
import org.jake.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public void addAuthor(Author author){
        authorRepository.save(author);
    }

    public void removeAuthor(Author author){
        authorRepository.delete(author);
    }

    public Author getAuthor(int id){
        return authorRepository.findById(id).get();
    }

    public boolean authorExists(Author author){
        return authorRepository.existsById(author.getId());
    }
}
