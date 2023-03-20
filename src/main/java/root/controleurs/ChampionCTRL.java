package root.controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import root.entites.Champion;
import root.services.ChampionService;

@RestController
@CrossOrigin(value = { "https://way-one.vercel.app/"})
public class ChampionCTRL {
	
	
	
	@Autowired
	private ChampionService champServ;
	
	
	
	@GetMapping("/yagAPI/get/champion")
	public ResponseEntity<List<Champion>> championList() {
		
		List<Champion> champList = champServ.getAllChampion();
		
		
		return ResponseEntity.ok(champList);		
	}


}
