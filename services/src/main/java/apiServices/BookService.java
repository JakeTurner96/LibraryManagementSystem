package apiServices;

import entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import repositorys.BookRepository;

public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void removeBook(Book book){
        bookRepository.delete(book);
    }

    public Book getBook(int id){
        return bookRepository.findById(id).get();
    }

    public boolean bookExists(Book book){
        return bookRepository.existsById(book.getAuthorID());
    }
}
