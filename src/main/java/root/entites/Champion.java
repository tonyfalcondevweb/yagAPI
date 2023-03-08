package root.entites;

import java.io.Serializable;
import java.util.Collection;

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

	@JoinTable(name = "champion_categorie", joinColumns = {
			@JoinColumn(name = "id_champion", referencedColumnName = "id_champion") }, inverseJoinColumns = {
					@JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie") })
	@ManyToMany
	private Collection<Categorie> categorieCollection;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "champion")
	private Collection<Compte> compteCollection;

	public Champion() {
	}

	public Champion(Integer idChampion) {
		this.idChampion = idChampion;
	}

	public Champion(Integer idChampion, String nom) {
		this.idChampion = idChampion;
		this.nom = nom;
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
		return "yagbdd.Champion[ idChampion=" + idChampion + " ]";
	}

}
