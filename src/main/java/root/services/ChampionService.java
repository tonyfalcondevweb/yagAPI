package root.services;

import java.util.List;
import java.util.Map;

import root.entites.Champion;
import root.inputs.ChampionInputs;

public interface ChampionService {
	
	
	
	public List<Champion> getAllChampion ();
	public List<Map<String, Object>> getClassement ();
	public Champion postChampionAdd (ChampionInputs inputs);
}
