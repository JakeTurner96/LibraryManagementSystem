package org.jake.library.repositories;

import org.jake.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM BOOK WHERE NAME LIKE '%' || :keyword || '%'", nativeQuery = true)
     List<Book> bookSearch(@Param("keyword") String keyword);
}
