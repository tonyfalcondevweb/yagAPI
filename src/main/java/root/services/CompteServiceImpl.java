package root.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.entites.Champion;
import root.entites.Compte;
import root.inputs.CompteInputs;
import root.repository.CompteRepository;

@Service
public class CompteServiceImpl implements CompteService {

	private CompteRepository CompteRep;

	@Autowired
	public CompteServiceImpl(CompteRepository CompteRep) {
		this.CompteRep = CompteRep;
	}

	public Compte updateCompte(CompteInputs inputs) throws Exception {

		Boolean erreur = false;

		Compte compteUpdate = new Compte();
		Champion champUpdate = new Champion();

		champUpdate.setIdChampion(inputs.getIdChampion());

		compteUpdate.setNom(inputs.getNom());
		compteUpdate.setChampion(champUpdate);

		if (
				!compteUpdate.getNom().isBlank() 
				&& !compteUpdate.getNom().isEmpty()
				&& champUpdate.getIdChampion() instanceof Integer
			) {

			// Recupere le compte par le nom
			Optional<Compte> option = CompteRep.findById(inputs.getNom());

			// Si le compte n'existe pas il le créer
			if (option.isEmpty() == true) {

				CompteRep.save(compteUpdate);

			}
			// sinon il le met à jour via l'idCompte
			else {

				compteUpdate.setIdCompte(option.get().getIdCompte());

				CompteRep.save(compteUpdate);
			}
			
			System.out.println(compteUpdate);

		}
		
		else {
			erreur = true;
			
			System.out.println("erreur");

		}

	
		if (erreur == true) {			
			throw new Exception("Erreur sur la mise a jour du compte");			
		}


		return compteUpdate;
	}

}
