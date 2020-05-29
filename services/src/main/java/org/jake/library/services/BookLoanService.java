package org.jake.library.services;

import lombok.RequiredArgsConstructor;
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

    public List<BookLoan> getPatronBookLoans(int patronID) {
        return bookLoanRepository.getPatronBookLoans(patronID);
    }

    public List<BookLoan> getPatronOverdueBooks(int patronID) {
        return bookLoanRepository.getPatronOverdueBooks(patronID);
    }

    public List<Integer> getOverduePatrons() {
        return bookLoanRepository.getOverduePatrons();
    }
}
