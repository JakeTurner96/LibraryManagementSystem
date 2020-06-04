package org.jake.library.services;

import lombok.RequiredArgsConstructor;
import org.jake.exceptions.AuthorNotFoundException;
import org.jake.library.entities.Author;
import org.jake.library.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author getAuthor(int authorId) {
        if(!authorRepository.existsById(authorId)){
            throw new AuthorNotFoundException("An author with id " + authorId + " could not be found");
        } else {
            return authorRepository.findById(authorId).get();
        }
    }

    public List<Author> getAuthorList() {
        return authorRepository.findAll();
    }

    public void removeAuthor(int authorId) {
        if(!authorRepository.existsById(authorId)){
            throw new AuthorNotFoundException("An author with id " + authorId + " could not be found");
        }else{
            authorRepository.deleteById(authorId);
        }
    }
}
