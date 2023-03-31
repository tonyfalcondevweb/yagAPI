package root.entites;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "compte")
public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;
  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compte")
    private Integer idCompte;
    
    @Id
    @Column(name = "nom")
    private String nom;
    
    
    @JoinColumns({
        @JoinColumn(name = "id_champion", referencedColumnName = "id_champion")})
    @ManyToOne(optional = false)
    private Champion champion;

    public Compte() {
    }

    public Compte(Integer idCompte) {
        this.idCompte = idCompte;
    }

    public Compte(Integer idCompte, String nom) {
        this.idCompte = idCompte;
        this.nom = nom;
    }

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

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", nom=" + nom + ", champion=" + champion + "]";
	}    
    
    
}
