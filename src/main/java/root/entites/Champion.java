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
import jakarta.persistence.ManyToOne;
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
	
    @JoinColumn(name = "id_interne", referencedColumnName = "id_interne")
    @ManyToOne
    private Interne idInterne;
	
	
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

    public Interne getIdInterne() {
        return idInterne;
    }

    public void setIdInterne(Interne idInterne) {
        this.idInterne = idInterne;
    }

    public Collection<Compte> getCompteCollection() {
        return compteCollection;
    }

    public void setCompteCollection(Collection<Compte> compteCollection) {
        this.compteCollection = compteCollection;
    }



    @Override
    public String toString() {
        return "wayimport.Champion[ idChampion=" + idChampion + " ]";
    }


	

}
