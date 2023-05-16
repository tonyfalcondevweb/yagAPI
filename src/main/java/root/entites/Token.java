package root.entites;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "token")
public class Token implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token")
    private Integer idToken;
    
    
    
    @Basic(optional = false)
    @Column(name = "token_key")
    private String tokenKey;
    
    
    @JoinColumn(name = "id_interne", referencedColumnName = "id_interne")
    @ManyToOne(optional = false)
    private Interne idInterne;

    public Token() {
    }

    public Token(Integer idToken) {
        this.idToken = idToken;
    }

    public Token(Integer idToken, String tokenKey) {
        this.idToken = idToken;
        this.tokenKey = tokenKey;
    }

    public Integer getIdToken() {
        return idToken;
    }

    public void setIdToken(Integer idToken) {
        this.idToken = idToken;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public Interne getIdInterne() {
        return idInterne;
    }

    public void setIdInterne(Interne idInterne) {
        this.idInterne = idInterne;
    }


    @Override
    public String toString() {
        return "wayimport.Token[ idToken=" + idToken + " ]";
    }

}
