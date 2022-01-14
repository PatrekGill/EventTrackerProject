package com.skilldistillery.mygamelist.services.company;

import java.util.List;

import com.skilldistillery.mygamelist.CRUDObject;
import com.skilldistillery.mygamelist.entities.Company;

public interface CompanyService extends CRUDObject<Company, Integer> {
	List<Company> findAll();
	List<Company> findByNameLike(String name);

}
