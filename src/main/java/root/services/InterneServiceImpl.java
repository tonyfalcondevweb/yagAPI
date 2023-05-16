package root.services;

import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import root.entites.Interne;
import root.entites.Token;
import root.inputs.LoginResponse;
import root.repository.InterneRepository;
import root.repository.RoleRepository;
import root.repository.TokenRepository;
import root.security.PasswordEncoderService;
import root.security.Regex;


@Service
public class InterneServiceImpl implements InterneService{

	private InterneRepository InterneRep;
	private PasswordEncoderService encodeur;
	private TokenRepository tokenRep;
	private RoleRepository roleRep;

	@Autowired
	public InterneServiceImpl(InterneRepository InterneRep, PasswordEncoderService encodeur, TokenRepository tokenRep,
			RoleRepository roleRep) {
		this.InterneRep = InterneRep;
		this.encodeur = encodeur;
		this.tokenRep = tokenRep;
		this.roleRep = roleRep;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private Token genererToken() {

		Token token = new Token();

		UUID uuid = UUID.randomUUID();
		String valeur = uuid.toString();

		token.setTokenKey(valeur);

		return token;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public LoginResponse login(String nom, String mdp) throws Exception {

		LoginResponse lr = new LoginResponse();

		nom = nom.trim();

		boolean erreur = false;

		if (nom.matches(Regex.regexLogin) == true && mdp.matches(Regex.regexLogin) == true) {

			Optional<Interne> op = InterneRep.findById(nom);

			if (op.isPresent()) {

				boolean ok = encodeur.verifier(mdp, op.get().getInterneKey());

				if (ok == true) {

					Token token = genererToken();
					token.setIdInterne(op.get());
					tokenRep.save(token);

					lr.setNom(op.get().getNom());
					lr.setRole(op.get().getIdRole().getNom());
					lr.setToken(token.getTokenKey());

				} else {
					erreur = true;
				}

			} else {
				erreur = true;
			}

		} else {
			erreur = true;
		}
		
		if (erreur == true) {			
			throw new Exception("Erreur sur l'identifiant ou le mot de passe");			
		}

		return lr;
	}
	
	
	
	
	
	
	
	@Override
	public Optional<Token> identifierToken(HttpServletRequest request) {

		String valeurToken = request.getHeader("Authorization");
		if (valeurToken == null) {
			return Optional.empty();
		}
		valeurToken = valeurToken.replace("Bearer ", "");
		Optional<Token> option = tokenRep.selectByKey(valeurToken);

		return option;
	}
	
	
	
	
	
	
}
