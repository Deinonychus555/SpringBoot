package hello;

import java.util.List;

// JPA
import org.springframework.data.jpa.repository.JpaRepository;
// Accessing JPA Data with REST - JPA
import org.springframework.data.repository.query.Param;


//import org.springframework.data.repository.CrudRepository;

// Accessing JPA Data with REST
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Accessing JPA Data with REST
@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(@Param("lastName")String lastName);
}
