package root.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import root.inputs.LoginInputs;
import root.security.PasswordEncoderService;

@Service
public class AdminServiceImpl implements AdminService {
	

	private PasswordEncoderService encodeur;
	
	@Autowired
	public AdminServiceImpl(PasswordEncoderService encodeur) {
		
		this.encodeur = encodeur;
	}


	public Boolean login(LoginInputs inputs) {

//		email = email.trim();
//		Regex
		
		
		String mdpcryp = encodeur.hasher(inputs.getKeyLog());
		

		
		
		boolean ok = encodeur.verifier(inputs.getKeyLog(), ${adminLogin});
		
		

		


		return ok;

	}

}
