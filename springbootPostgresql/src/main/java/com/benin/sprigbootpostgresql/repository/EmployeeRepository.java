package com.benin.sprigbootpostgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benin.sprigbootpostgresql.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
