package com.hello.domain;

import java.util.Collection;

// JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
// Accessing JPA Data with REST - JPA
import org.springframework.data.repository.query.Param;
// Accessing JPA Data with REST
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Accessing JPA Data with REST
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Collection<Booking> findByBookingName(@Param("bookingName")String bookingName);
    
    @Query("SELECT b FROM Booking b WHERE b.bookingName LIKE CONCAT(:bookingName, '%') AND b.id < :id")
    Collection<Booking> findByBookName(@Param("bookingName")String bookingName, @Param("id")Long id );
    
}
