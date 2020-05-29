package org.jake.library.repositories;

import org.jake.library.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PatronRepository extends JpaRepository<Patron, Integer> {

    Optional<Patron> findByEmail(String email);

    @Query(value = "SELECT * FROM PATRON WHERE NAME LIKE '%' || :keyword || '%'", nativeQuery = true)
    List<Patron> patronSearch(@Param("keyword") String keyword);
}
