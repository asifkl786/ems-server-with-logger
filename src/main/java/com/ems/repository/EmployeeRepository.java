package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	
	// This is custom search method JPQL QUERY
    @Query("SELECT p FROM Employee p WHERE " +
           "p.firstName LIKE CONCAT('%', :query, '%')" +
            "Or p.lastName LIKE CONCAT('%', :query, '%')" +
            "Or p.middleName LIKE CONCAT('%', :query, '%')"  +
            "Or p.email LIKE CONCAT('%', :query, '%')" +
            "Or p.mobileNumber LIKE CONCAT('%', :query, '%')" )
    List<Employee> SearchEmployee(String query);

    // This is search method  native query
   /* @Query(value = "SELECT * FROM employees p WHERE " +
            "p.lastName LIKE CONCAT('%', :querys, '%')" +
            "Or p.middleName LIKE CONCAT('%', :querys, '%')",nativeQuery = true)
    List<Employee> SearchEmployeeNativeSQL(String querys);*/
}