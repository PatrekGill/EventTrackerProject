package com.skilldistillery.mygamelist.controllers.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.entities.Company;
import com.skilldistillery.mygamelist.entities.Game;
import com.skilldistillery.mygamelist.services.CompanyService;

@RestController
@RequestMapping("api")
public class CompanyModifyController {
	@Autowired
	private CompanyService companyService;
	

	/* ----------------------------------------------------------------------------
		POST create company
	---------------------------------------------------------------------------- */
	@PostMapping("companies")
	public Company createCompany(
		@RequestBody Company company,
		HttpServletResponse res,
		HttpServletRequest req
	) {
		
		try {
			company = companyService.create(company);
			res.setStatus(201);
			
			StringBuffer url = req.getRequestURL();
			url.append("/").append(company.getId());
			res.setHeader("Location",url.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid company sent to create");
			res.setStatus(400);
			company = null;
			
		}
		
		return company;
	}
	

	/* ----------------------------------------------------------------------------
		PUT update Company
	---------------------------------------------------------------------------- */
	@PutMapping("companies/{id}")
	public Company updateCompany(
		@PathVariable int id,
		@RequestBody Company company,
		HttpServletResponse res
	) {
		try {
			company = companyService.update(id, company);
			if (company == null) {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Invalid company sent to update");
			res.setStatus(400);
			company = null;
			
		}
		
		return company;
	}
}
