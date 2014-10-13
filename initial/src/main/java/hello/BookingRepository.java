package hello;

import java.util.Collection;

// JPA
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
// Accessing JPA Data with REST - JPA
import org.springframework.data.repository.query.Param;
// Accessing JPA Data with REST
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Accessing JPA Data with REST
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Collection<Booking> findByBookingName(@Param("bookingName")String bookingName);
}
