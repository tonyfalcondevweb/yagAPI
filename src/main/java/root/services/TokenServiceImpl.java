package root.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.repository.TokenRepository;


@Service
public class TokenServiceImpl implements TokenService{
	
	
	
	private TokenRepository TokenRep;
	
	@Autowired
	public TokenServiceImpl (TokenRepository TokenRep) {
		this.TokenRep = TokenRep;
	}


}
