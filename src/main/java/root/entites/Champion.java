package root.entites;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "champion")
public class Champion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_champion")
	private Integer idChampion;

	
	@Column(name = "nom")
	private String nom;

	
	@Column(name = "key_riot")
	private Integer keyRiot;
	
	


	
	@JoinTable(name = "champion_categorie", joinColumns = {
			@JoinColumn(name = "id_champion", referencedColumnName = "id_champion") }, inverseJoinColumns = {
					@JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie") })
	@ManyToMany
	@JsonIgnoreProperties({"championCollection" , "champion_categorie"})
	private Collection<Categorie> categorieCollection;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "champion")
	private Collection<Compte> compteCollection;
	
	
	public Champion() {
		super();
	}




	public Champion(String nom) {
		super();
		this.nom = nom;
	}




	public Champion(Integer idChampion, String nom, Integer keyRiot) {
		super();
		this.idChampion = idChampion;
		this.nom = nom;
		this.keyRiot = keyRiot;
	}




	public Champion(Integer idChampion, String nom, Integer keyRiot, Collection<Categorie> categorieCollection,
			Collection<Compte> compteCollection) {
		super();
		this.idChampion = idChampion;
		this.nom = nom;
		this.keyRiot = keyRiot;
		this.categorieCollection = categorieCollection;
		this.compteCollection = compteCollection;
	}




	public Integer getIdChampion() {
		return idChampion;
	}

	public void setIdChampion(Integer idChampion) {
		this.idChampion = idChampion;
	}

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

	public Collection<Compte> getCompteCollection() {
		return compteCollection;
	}

	public void setCompteCollection(Collection<Compte> compteCollection) {
		this.compteCollection = compteCollection;
	}




	@Override
	public String toString() {
		return "Champion [idChampion=" + idChampion + ", nom=" + nom + ", keyRiot=" + keyRiot + ", categorieCollection="
				+ categorieCollection + "]";
	}


	

}
