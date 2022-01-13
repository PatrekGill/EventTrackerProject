package com.skilldistillery.mygamelist.controllers.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.mygamelist.services.CompanyService;

@RestController
@RequestMapping("api")
public class CompanyModifyController {
	@Autowired
	private CompanyService companyService;
}
