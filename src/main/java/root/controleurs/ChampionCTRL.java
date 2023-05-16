package root.controleurs;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletRequest;
import root.entites.Champion;
import root.entites.Token;
import root.inputs.ChampionInputs;
import root.services.ChampionService;
import root.services.InterneService;

//@CrossOrigin(origins = "https://way-one.vercel.app/")
//@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class ChampionCTRL {

	@Autowired
	private ChampionService champServ;

	@Autowired
	private InterneService interneServ;

	@GetMapping("/yagAPI/get/champion")
	public ResponseEntity<List<Champion>> championList() {

		List<Champion> champList = champServ.getAllChampion();

		return ResponseEntity.ok(champList);
	}

	@GetMapping("/yagAPI/get/champion/classement")
	public ResponseEntity<List<Map<String, Object>>> getClassement() {

		List<Map<String, Object>> classement = champServ.getClassement();

		return ResponseEntity.ok(classement);
	}

	@PostMapping("/yagAPI/post/champion/add")
	public ResponseEntity<Champion> postChampionAdd(HttpServletRequest request, @RequestBody ChampionInputs inputs) {

		// on verifie si le token recu existe dans la bdd
		// si oui on verifie les droits et si les droits sont accordés alors on ajoute
		// le champion
		// sinon on revoit un message d'erreur
		Optional<Token> okAdmin = interneServ.identifierToken(request);

		if (okAdmin.isPresent()) {

			Champion champAdd = champServ.postChampionAdd(inputs);

			return ResponseEntity.ok(champAdd);

		} else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "accès refusé");
		}

	}

}
