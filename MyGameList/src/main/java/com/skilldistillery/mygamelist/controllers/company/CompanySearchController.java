package com.skilldistillery.mygamelist.controllers.company;

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
public class CompanySearchController {
	@Autowired
	private CompanyService companyService;
	
	/* ----------------------------------------------------------------------------
		GET  companies by name
	---------------------------------------------------------------------------- */
	@GetMapping("companies/search/{name}")
	public List<Company> getCompaniesByName(
		@PathVariable String name,
		HttpServletResponse res
	) {
		List<Company> companies = null;
		try {
			companies = companyService.findByNameLike(name);
			if (companies == null) {
				res.setStatus(400);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			
		}
		
		return companies;
	}
	
	@GetMapping("companies/search/{name}/{numberOfEntries}")
	public List<Company> getCompaniesByName(
		@PathVariable String name,
		@PathVariable int numberOfEntries,
		HttpServletResponse res
	) {
		List<Company> companies = null;
		try {
			
			companies = companyService.findByNameLike(name);
			int size = companies.size();
			
			if (numberOfEntries > size) {
				numberOfEntries = size;
			}
			
			companies = companies.subList(0, numberOfEntries);
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			
		}
		
		return companies;
	}
}
