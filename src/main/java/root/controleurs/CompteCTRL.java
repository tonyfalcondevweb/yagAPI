package root.controleurs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import root.entites.Compte;
import root.inputs.CompteInputs;
import root.services.CompteService;

@RestController
@CrossOrigin
public class CompteCTRL {
	
	@Autowired
	private CompteService CompteServ;
	
	
	@PostMapping("/yagAPI/post/compte")
	public ResponseEntity<Compte> updateCompte(@RequestBody CompteInputs inputs){
		

		
		Compte compteUpdate = new Compte();
		
//		System.out.println("envoie" + inputs);
		
		
		
		compteUpdate = CompteServ.updateCompte(inputs);
		
		
		return ResponseEntity.ok(null);
	}

}
