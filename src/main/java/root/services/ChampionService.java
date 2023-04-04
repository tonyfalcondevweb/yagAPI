package root.services;

import java.util.List;
import java.util.Map;

import root.entites.Champion;

public interface ChampionService {
	
	
	
	public List<Champion> getAllChampion ();
	public List<Map<String, Object>> getClassement ();

}
