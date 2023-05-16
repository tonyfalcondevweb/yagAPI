package root.services;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import root.entites.Token;
import root.inputs.LoginResponse;

public interface InterneService {

	public LoginResponse login(String nom, String mdp) throws Exception ;
	public Optional<Token> identifierToken(HttpServletRequest request);
}
