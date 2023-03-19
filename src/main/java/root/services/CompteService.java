package root.services;


import root.entites.Compte;
import root.inputs.CompteInputs;

public interface CompteService {
	
	public Compte updateCompte (CompteInputs inputs);

}
