package com.skilldistillery.mygamelist.services;

import java.util.List;

import com.skilldistillery.mygamelist.entities.Company;

public interface CompanyService {
	List<Company> getAllCompanies();
	Company getCompanyById(int id);
}
