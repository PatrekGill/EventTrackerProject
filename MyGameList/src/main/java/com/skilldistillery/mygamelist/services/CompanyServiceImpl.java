package com.skilldistillery.mygamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.mygamelist.OptionalRetriever;
import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepo;
	@Autowired
	private OptionalRetriever<Company> companyRetriever;
	
	@Override
	public List<Company> findAll() {
		return companyRepo.findAll();
	}

	@Override
	public Company findById(Integer id) {
		return companyRetriever.get(
			companyRepo.findById(id)
		);
	}

	@Override
	public List<Company> findByNameLike(String name) {
		List<Company> companies = null;
		if (name != null) {
			companies = companyRepo.findByNameLike("%" + name + "%");
		}
		
		return companies;
	}

	@Override
	public boolean existsById(Integer id) {
		return companyRepo.existsById(id);
	}

	@Override
	public Company create(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company update(Integer id,Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
