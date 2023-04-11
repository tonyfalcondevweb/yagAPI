package root.controleurs;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import root.entites.Champion;
import root.inputs.ChampionInputs;
import root.services.ChampionService;

//@CrossOrigin(origins = "https://way-one.vercel.app/")
//@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class ChampionCTRL {
	
	
	
	@Autowired
	private ChampionService champServ;
	
	

	@GetMapping("/yagAPI/get/champion")
	public ResponseEntity<List<Champion>> championList() {
		
		List<Champion> champList = champServ.getAllChampion();
		
		
		return ResponseEntity.ok(champList);		
	}

	@GetMapping("/yagAPI/get/champion/classement")
	public ResponseEntity <List<Map<String, Object>>> getClassement(){
		
		

		List<Map<String, Object>> classement = champServ.getClassement();
		

		return ResponseEntity.ok(classement);
	}
	
	@PostMapping("/yagAPI/post/champion/add")
	public ResponseEntity <Champion> postChampionAdd(@RequestBody ChampionInputs inputs){
		
		
		Champion champAdd = champServ.postChampionAdd(inputs);
		
		

		return ResponseEntity.ok(champAdd);
	}

}
