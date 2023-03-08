package root.services;

import org.springframework.beans.factory.annotation.Autowired;


import root.repository.CompteRepository;

public class CompteServiceImpl implements CompteService {
	
	private CompteRepository CompteRep;
	
	@Autowired
	public CompteServiceImpl (CompteRepository CompteRep) {
		this.CompteRep = CompteRep;
	}
}
