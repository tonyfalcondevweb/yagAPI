package root.inputs;


public class CompteInputs {
	
	private Integer idCompte;
	
	private String nom;
	
	private Integer idChampion;

	public Integer getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getIdChampion() {
		return idChampion;
	}

	public void setIdChampion(Integer idChampion) {
		this.idChampion = idChampion;
	}

	@Override
	public String toString() {
		return "CompteInputs [idCompte=" + idCompte + ", nom=" + nom + ", idChampion=" + idChampion + "]";
	}
	
	
	


}
