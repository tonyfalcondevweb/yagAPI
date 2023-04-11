package root.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.entites.Champion;
import root.inputs.ChampionInputs;
import root.repository.ChampionRepository;

@Service
public class ChampionServiceImpl implements ChampionService {

	private ChampionRepository ChampionRep;

	@Autowired
	public ChampionServiceImpl(ChampionRepository ChampionRep) {
		this.ChampionRep = ChampionRep;
	}

	public List<Champion> getAllChampion() {

		List<Champion> champList = ChampionRep.findAll();

		return champList;
	}

	public List<Map<String, Object>> getClassement() {

		List<Map<String, Object>> result = ChampionRep.findAllByGroupingProperty();

		for (Map<String, Object> row : result) {
		    String nom = (String) row.get("nom");
		    Integer idChampion = (Integer) row.get("idChampion");
		    Integer keyRiot = (Integer) row.get("keyRiot");
		    Long total = (Long) row.get("total");
		    
		    
		    
		    System.out.println("Nom : " + nom);
		    System.out.println("Id Champion : " + idChampion);
		    System.out.println("Key Riot : " + keyRiot);
		    System.out.println("Total : " + total);
		}

		return result;
	}
	
	
	public Champion postChampionAdd (ChampionInputs inputs) {
		
		
		Champion champAdd = new Champion();
		
		champAdd.setNom(inputs.getNom());
		champAdd.setKeyRiot(inputs.getKeyRiot());
		champAdd.setCategorieCollection(inputs.getCategorieCollection());
		
		ChampionRep.save(champAdd);


		
		return champAdd;
	}
}
