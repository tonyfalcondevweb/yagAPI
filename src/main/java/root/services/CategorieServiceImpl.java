package root.services;

import org.springframework.beans.factory.annotation.Autowired;

import root.repository.CategorieRepository;

public class CategorieServiceImpl implements CategorieService{
	
	private CategorieRepository categorieRep;
	
	@Autowired
	public CategorieServiceImpl (CategorieRepository categorieRep) {
		this.categorieRep = categorieRep;
	}

}
