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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable {
	
	
	
	
	private static final long serialVersionUID = 1L;
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Integer idRole;
    
    
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRole")
    private Collection<Interne> interneCollection;

    public Role() {
    }

    public Role(Integer idRole) {
        this.idRole = idRole;
    }

    public Role(Integer idRole, String nom) {
        this.idRole = idRole;
        this.nom = nom;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Interne> getInterneCollection() {
        return interneCollection;
    }

    public void setInterneCollection(Collection<Interne> interneCollection) {
        this.interneCollection = interneCollection;
    }

	@Override
	public String toString() {
		return "Role [nom=" + nom + "]";
	}
}
