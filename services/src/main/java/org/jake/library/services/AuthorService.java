package org.jake.library.services;

import lombok.RequiredArgsConstructor;
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

    public Author getAuthor(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<Author> getAuthorList() {
        return authorRepository.findAll();
    }

    public void removeAuthor(int id) {
        authorRepository.deleteById(id);
    }

    public boolean authorExists(Author author) {
        return authorRepository.existsById(author.getId());
    }
}
