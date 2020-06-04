package org.jake.library.services;

import lombok.RequiredArgsConstructor;
import org.jake.exceptions.BookNotFoundException;
import org.jake.library.entities.Book;
import org.jake.library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBook(int bookId) {
        if(!bookRepository.existsById(bookId)){
            throw new BookNotFoundException("A book with id " + bookId + " could not be found");
        }else{
            return bookRepository.findById(bookId).get();
        }
    }

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public void removeBook(int bookId) {
        if(!bookRepository.existsById(bookId)){
            throw new BookNotFoundException("A book with id " + bookId + " could not be found");
        }else{
            bookRepository.deleteById(bookId);
        }
    }

    public void decrementCopies(Book book) {
        if(!bookRepository.existsById(book.getId())){
            throw new BookNotFoundException("A book with id " + book.getId() + " could not be found");
        }else{
            if (book.getCopies() == 1) {
                book.setCopies(book.getCopies() - 1);
                book.setAvailable(false);
            } else if (book.getCopies() > 0) {
                book.setCopies(book.getCopies() - 1);
            }
            addBook(book);
        }
    }

    public void incrementCopies(Book book) {
        if(!bookRepository.existsById(book.getId())){
            throw new BookNotFoundException("A book with id " + book.getId() + " could not be found");
        }else {
            if (!book.isAvailable()) {
                book.setCopies(book.getCopies() + 1);
                book.setAvailable(true);
            } else {
                book.setCopies(book.getCopies() + 1);
            }
            addBook(book);
        }
    }
}
