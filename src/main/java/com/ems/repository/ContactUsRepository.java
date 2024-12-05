package com.ems.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.entity.ContactUs;

public interface ContactUsRepository extends JpaRepository<ContactUs,Long> {
	
	 Page<ContactUs> findAll(Pageable pageable);
	
	// This is custom search method JPQL QUERY
    @Query("SELECT p FROM ContactUs p WHERE " +
           "p.name LIKE CONCAT('%', :query, '%')" +
            "Or p.email LIKE CONCAT('%', :query, '%')" )
    List<ContactUs> SearchContact(String query);

}
