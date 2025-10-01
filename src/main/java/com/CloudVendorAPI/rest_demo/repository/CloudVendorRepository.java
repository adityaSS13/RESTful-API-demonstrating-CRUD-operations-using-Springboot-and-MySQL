package com.CloudVendorAPI.rest_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CloudVendorAPI.rest_demo.model.CloudVendor;
/*
The first generic (CloudVendor) is the entity type the repository manages.
The second generic (String) is the type of the entity's primary key (@Id).
All JpaRepository methods are typed: save(CloudVendor), findById(String), etc. The generics give 
compile-time type safety and correct method signatures.
The ID generic must match the actual type of the @Id field in your CloudVendor entity 
(e.g., Long, UUID, String). 
 */
public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

}

//what is repository?
//A repository in Spring Data JPA is a mechanism for encapsulating storage, retrieval, and search behavior
// which emulates a collection of objects. It acts as a bridge between the application and the database,
// providing an abstraction layer that simplifies data access and manipulation. By extending repository 
// interfaces like JpaRepository, developers can leverage built-in CRUD operations and query methods without
// needing to write boilerplate code, thus enhancing productivity and maintainability in data-driven 
// applications.

// why @Repository annotation is not used here?
//In Spring Data JPA, when you create a repository interface that extends one of the Spring Data repository
// interfaces (like JpaRepository, CrudRepository, etc.), you do not need to annotate it with @Repository.
// This is because Spring Data automatically detects these interfaces and creates proxy implementations 
