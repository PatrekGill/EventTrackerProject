package com.skilldistillery.mygamelist.services.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepo;
	@Autowired
	private OptionalRetriever<Company> retriever;
	@Override
	public JpaRepository<Company, Integer> getRepo() {
		return companyRepo;
	}
	@Override
	public OptionalRetriever<Company> getRetriever() {
		return retriever;
	}

	@Override
	public List<Company> findByNameLike(String name) {
		List<Company> companies = null;
		if (name != null) {
			companies = companyRepo.findByNameLike("%" + name + "%");
		}
		
		return companies;
	}

}
