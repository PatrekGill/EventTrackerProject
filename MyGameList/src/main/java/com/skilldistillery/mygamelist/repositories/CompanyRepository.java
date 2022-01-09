package com.skilldistillery.mygamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.mygamelist.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
