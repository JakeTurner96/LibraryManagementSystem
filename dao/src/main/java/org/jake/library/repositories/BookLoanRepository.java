package org.jake.library.repositories;

import org.jake.library.entities.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {

    @Query(value = "SELECT * FROM BOOK_LOAN WHERE PATRON_ID = :patronID", nativeQuery = true)
    List<BookLoan> getPatronBookLoans(@Param("patronID") int patronID);

}
