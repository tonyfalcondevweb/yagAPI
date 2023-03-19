package root.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.entites.Champion;
import root.repository.ChampionRepository;


@Service
public class ChampionServiceImpl implements ChampionService {
	
	private ChampionRepository ChampionRep;
	
	@Autowired
	public ChampionServiceImpl (ChampionRepository ChampionRep) {
		this.ChampionRep = ChampionRep;
	}
	
	
	
	public List<Champion> getAllChampion () {
		
		List<Champion> champList = ChampionRep.findAll();
		
		return champList;
	}
}
