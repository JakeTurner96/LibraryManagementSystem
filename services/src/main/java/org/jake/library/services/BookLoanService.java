package org.jake.library.services;

import lombok.RequiredArgsConstructor;
import org.jake.library.entities.Book;
import org.jake.library.entities.BookLoan;
import org.jake.library.repositories.BookLoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanService {


    private final BookLoanRepository bookLoanRepository;

    public void addBookLoan(BookLoan bookLoan) {
        bookLoanRepository.save(bookLoan);
    }

    public void removeBookLoan(int id) {
        bookLoanRepository.deleteById(id);
    }

    public BookLoan getBookLoan(int id) {
        return bookLoanRepository.findById(id).orElse(null);
    }

    public List<BookLoan> getBookLoanList() {
        return bookLoanRepository.findAll();
    }

    public boolean bookLoanExists(BookLoan bookLoan) {
        return bookLoanRepository.existsById(bookLoan.getId());
    }

    public List<BookLoan> searchBookLoan(Integer patronID){
        return bookLoanRepository.bookLoanSearch(patronID);
    }

}
