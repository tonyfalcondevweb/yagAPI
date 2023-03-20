package root.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import root.entites.Categorie;
import root.services.CategorieService;

@RestController
public class CategorieCTRL {
	
	
	@Autowired
	private CategorieService cateServ;
	
	
	@CrossOrigin(origins = "https://way-one.vercel.app/")
	@GetMapping("/yagAPI/get/categorie")
	public ResponseEntity<List<Categorie>> getAllCategorie() {

		List<Categorie> categorieList = cateServ.getAllCategorie();
		
		
		return ResponseEntity.ok(categorieList);
	}
}
