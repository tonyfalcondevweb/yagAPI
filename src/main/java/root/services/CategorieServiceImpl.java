package root.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import root.entites.Categorie;
import root.repository.CategorieRepository;


@Service
public class CategorieServiceImpl implements CategorieService{
	
	private CategorieRepository categorieRep;
	
	@Autowired
	public CategorieServiceImpl (CategorieRepository categorieRep) {
		this.categorieRep = categorieRep;
	}
	
	public List<Categorie> getAllCategorie () {
		
		List<Categorie> categorieList = categorieRep.findAll(Sort.by("idCategorie"));
		
		
		return categorieList;
		
	}

}
