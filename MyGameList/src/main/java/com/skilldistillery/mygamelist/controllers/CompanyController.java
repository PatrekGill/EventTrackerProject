package com.skilldistillery.mygamelist.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.services.CompanyService;

@RestController
@RequestMapping("api")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	/* ----------------------------------------------------------------------------
		GET all companies
	---------------------------------------------------------------------------- */
	@GetMapping("companies")
	public List<Company> index() {
		return companyService.getAllCompanies();
	}
	
	
	/* ----------------------------------------------------------------------------
		GET Company by id
	---------------------------------------------------------------------------- */
	@GetMapping("companies/{id}")
	public Company getCompanyById(
		@PathVariable int id,
		HttpServletResponse res
	) {
		Company company = null;
		try {
			company = companyService.getCompanyById(id);
			if (company == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
		return company;
	}
}
