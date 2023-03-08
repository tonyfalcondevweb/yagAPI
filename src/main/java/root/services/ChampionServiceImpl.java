package root.services;

import org.springframework.beans.factory.annotation.Autowired;


import root.repository.ChampionRepository;

public class ChampionServiceImpl implements ChampionService {
	
	private ChampionRepository ChampionRep;
	
	@Autowired
	public ChampionServiceImpl (ChampionRepository ChampionRep) {
		this.ChampionRep = ChampionRep;
	}
}
