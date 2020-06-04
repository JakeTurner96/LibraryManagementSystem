package org.jake.library.services;

import lombok.RequiredArgsConstructor;
import org.jake.exceptions.BookLoanNotFoundException;
import org.jake.exceptions.PatronNotFoundException;
import org.jake.library.entities.BookLoan;
import org.jake.library.repositories.BookLoanRepository;
import org.jake.library.repositories.PatronRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookLoanService {

    private final BookLoanRepository bookLoanRepository;
    private final PatronRepository patronRepository;

    public void addBookLoan(BookLoan bookLoan) {
        bookLoanRepository.save(bookLoan);
    }

    public void removeBookLoan(int loanId) {
        if(!bookLoanRepository.existsById(loanId)){
            throw new BookLoanNotFoundException("A book loan with id " + loanId + " could not be found");
        }else{
            bookLoanRepository.deleteById(loanId);
        }
    }

    public BookLoan getBookLoan(int loanId) {
        if(!bookLoanRepository.existsById(loanId)){
            throw new BookLoanNotFoundException("A book loan with id " + loanId + " could not be found");
        }else{
            return bookLoanRepository.findById(loanId).get();
        }
    }

    public List<BookLoan> getBookLoanList() {
        return bookLoanRepository.findAll();
    }

    public List<BookLoan> getPatronBookLoans(int patronID) {
        if(!patronRepository.existsById(patronID)){
            throw new PatronNotFoundException("A patron with ID " + patronID + " could not be found");
        }else{
            return bookLoanRepository.getPatronBookLoans(patronID);
        }
    }

    public List<BookLoan> getPatronOverdueBooks(int patronID) {
        if(!patronRepository.existsById(patronID)){
            throw new PatronNotFoundException("A patron with ID " + patronID + " could not be found");
        }else{
            return bookLoanRepository.getPatronOverdueBooks(patronID);
        }
    }

    public List<Integer> getOverduePatrons() {
        return bookLoanRepository.getOverduePatrons();
    }
}
