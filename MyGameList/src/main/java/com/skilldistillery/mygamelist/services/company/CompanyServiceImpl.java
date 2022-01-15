package com.skilldistillery.mygamelist.services.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl extends CRUDObject<Company, Integer> implements CompanyService {
	@Autowired
	private CompanyRepository companyRepo;

	@Override
	public List<Company> findByNameLike(String name) {
		List<Company> companies = null;
		if (name != null) {
			companies = companyRepo.findByNameLike("%" + name + "%");
		}
		
		return companies;
	}

}
