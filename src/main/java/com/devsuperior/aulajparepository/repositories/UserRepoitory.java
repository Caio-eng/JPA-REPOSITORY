package com.devsuperior.aulajparepository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.aulajparepository.entites.User;

public interface UserRepoitory extends JpaRepository<User, Long>{
	
	@Query("SELECT obj FROM User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
	Page<User> searchSalary(Double minSalary, Double maxSalary, Pageable pageable);
	
	@Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> searchName(String name, Pageable pageable);
	
	// Faz a mesma coisa que o searchSalary, sem precisar da Query
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);
	
	//Subistitui o searchName
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);

}
