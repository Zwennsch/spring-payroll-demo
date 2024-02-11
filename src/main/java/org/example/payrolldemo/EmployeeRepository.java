package org.example.payrolldemo;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository is part of Spring Data JPA, and it provides CRUD (Create, Read, Update, Delete) operations for your Employee entity. 
// By extending JpaRepository, you inherit methods like save, findById, findAll, etc., without needing to implement them yourself.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
