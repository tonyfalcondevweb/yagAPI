package root.entites;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Categorie implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categorie")
	private Integer idCategorie;
	
	
	@Column(name = "nom")
	private String nom;
	
	@JsonIgnore
    @ManyToMany(mappedBy = "categorieCollection")
    private Collection<Champion> championCollection;
    
    
    
    public Categorie() {
    }

    public Categorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Categorie(Integer idCategorie, String nom) {
        this.idCategorie = idCategorie;
        this.nom = nom;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Champion> getChampionCollection() {
        return championCollection;
    }

    public void setChampionCollection(Collection<Champion> championCollection) {
        this.championCollection = championCollection;
    }

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nom=" + nom + "]";
	}    
    
}
