package root.inputs;

public class LoginInputs {
	
	
	private String nom;

	private String interneKey;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getInterneKey() {
		return interneKey;
	}

	public void setInterneKey(String interneKey) {
		this.interneKey = interneKey;
	}

	@Override
	public String toString() {
		return "LoginInputs [nom=" + nom + ", interneKey=" + interneKey + "]";
	}
}
