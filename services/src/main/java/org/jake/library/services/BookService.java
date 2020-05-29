package org.jake.library.services;

import lombok.RequiredArgsConstructor;
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

    public Book getBook(int id) {
        return bookRepository.findById(id).get();
    }

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public void removeBook(int id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBook(String keyword) {
        return bookRepository.bookSearch(keyword);
    }

    public void decrementCopies(Book book) {
        if (book.getCopies() == 1) {
            book.setCopies(book.getCopies() - 1);
            book.setAvailable(false);
        } else if (book.getCopies() > 0) {
            book.setCopies(book.getCopies() - 1);
        }
        addBook(book);
    }

    public void incrementCopies(Book book) {
        if (!book.isAvailable()) {
            book.setCopies(book.getCopies() + 1);
            book.setAvailable(true);
        } else {
            book.setCopies(book.getCopies() + 1);
        }
        addBook(book);
    }
}
