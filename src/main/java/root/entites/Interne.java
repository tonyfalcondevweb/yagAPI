package root.entites;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "interne")
public class Interne implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interne")
    private Integer idInterne;
    
    @Id
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    
    
    @Basic(optional = false)
    @Column(name = "interne_key")
    private String interneKey;
    
    
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    @ManyToOne(optional = false)
    private Role idRole;
    
    
    @OneToMany(mappedBy = "idInterne")
    private Collection<Champion> championCollection;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInterne")
    private Collection<Token> tokenCollection;

    public Interne() {
    }

    public Interne(Integer idInterne) {
        this.idInterne = idInterne;
    }

    public Interne(Integer idInterne, String nom, String interneKey) {
        this.idInterne = idInterne;
        this.nom = nom;
        this.interneKey = interneKey;
    }

    public Integer getIdInterne() {
        return idInterne;
    }

    public void setIdInterne(Integer idInterne) {
        this.idInterne = idInterne;
    }

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

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    public Collection<Champion> getChampionCollection() {
        return championCollection;
    }

    public void setChampionCollection(Collection<Champion> championCollection) {
        this.championCollection = championCollection;
    }

    public Collection<Token> getTokenCollection() {
        return tokenCollection;
    }

    public void setTokenCollection(Collection<Token> tokenCollection) {
        this.tokenCollection = tokenCollection;
    }

	@Override
	public String toString() {
		return "Interne [nom=" + nom + ", interneKey=" + interneKey + ", idRole=" + idRole + "]";
	}

}
