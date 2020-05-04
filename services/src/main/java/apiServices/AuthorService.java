package apiServices;

import entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorys.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

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
        return authorRepository.existsById(author.getAuthorID());
    }
}
