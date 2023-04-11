package root.inputs;

import java.util.Collection;

import root.entites.Categorie;

public class ChampionInputs {

	
	private String nom;
	
	private Integer keyRiot;
	
	private Collection<Categorie> categorieCollection;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getKeyRiot() {
		return keyRiot;
	}

	public void setKeyRiot(Integer keyRiot) {
		this.keyRiot = keyRiot;
	}

	public Collection<Categorie> getCategorieCollection() {
		return categorieCollection;
	}

	public void setCategorieCollection(Collection<Categorie> categorieCollection) {
		this.categorieCollection = categorieCollection;
	}

	@Override
	public String toString() {
		return "ChampionInputs [nom=" + nom + ", keyRiot=" + keyRiot + ", categorieCollection=" + categorieCollection
				+ "]";
	}
	
	
}
