package com.hello.domain;

import java.util.List;

// JPA
import org.springframework.data.repository.PagingAndSortingRepository;
// Accessing JPA Data with REST - JPA
import org.springframework.data.repository.query.Param;

// Accessing JPA Data with REST
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Accessing JPA Data with REST
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	List<Person> findByLastName(@Param("name") String name);

}
