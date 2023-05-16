package root.inputs;

public class LoginResponse {
	
	private String nom;
	private String token;
	private String role;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "LoginResponse [nom=" + nom + ", token=" + token + ", role=" + role + "]";
	}
	
}
