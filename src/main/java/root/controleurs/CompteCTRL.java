package root.controleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import root.entites.Compte;
import root.inputs.CompteInputs;
import root.services.CompteService;

//@CrossOrigin(origins = "https://way-one.vercel.app/")
//@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class CompteCTRL {

	@Autowired
	private CompteService CompteServ;

	@PostMapping("/yagAPI/post/compte")
	public ResponseEntity<Compte> updateCompte(@RequestBody CompteInputs inputs) {

		Compte compteUpdate = new Compte();

//		faire un regex pour vérifier les données qui sont save dans Compte WAY API

		try {
			
			compteUpdate = CompteServ.updateCompte(inputs);
			return ResponseEntity.ok(compteUpdate);
			
		} catch (Exception ex) {
			
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
		
		}


	}

}
