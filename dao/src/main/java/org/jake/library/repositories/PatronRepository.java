package org.jake.library.repositories;

import org.jake.library.entities.Book;
import org.jake.library.entities.Patron;
import org.omg.CORBA.LongLongSeqHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatronRepository extends JpaRepository<Patron, Integer> {

//    @Modifying
//    @Query(value = "UPDATE patron SET email =  :newEmail, member_since = :newMemberSince, membership_expires = :newExpiration, name = :newName, patron_type = :newPatronType WHERE id = :id", nativeQuery = true)
//    Void updatePatron(@Param("newEmail") String newEmail, @Param("newMemberSince") LocalDate newMemberSince, @Param("newExpiration") LocalDate newExpiration, @Param("newName") String name, @Param("newPatronType") Patron.PatronType newPatronType, @Param("id") int patronID);

}
