package org.jake.library.repositories;

import org.jake.library.entities.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {

    @Query(value = "SELECT * FROM BOOK_LOAN WHERE PATRON_ID = :patronID", nativeQuery = true)
    List<BookLoan> getPatronBookLoans(@Param("patronID") int patronID);

    @Query(value = "SELECT * FROM BOOK_LOAN WHERE CURDATE() > DATE_DUE AND PATRON_ID = :patronID", nativeQuery = true)
    List<BookLoan> getPatronOverdueBooks(@Param("patronID") int patronID);

    @Query(value = "SELECT DISTINCT PATRON_ID FROM BOOK_LOAN  WHERE CURDATE() > DATE_DUE", nativeQuery = true)
    List<Integer> getOverduePatrons();
}