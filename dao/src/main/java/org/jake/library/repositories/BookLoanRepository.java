package org.jake.library.repositories;

import org.jake.library.entities.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {
}
