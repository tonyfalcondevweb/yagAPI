package root.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import root.inputs.LoginInputs;
import root.security.PasswordEncoderService;

@Service
public class AdminServiceImpl implements AdminService {
	

	private PasswordEncoderService encodeur;
	
	
    @Autowired
    private Environment env;
	
	@Autowired
	public AdminServiceImpl(PasswordEncoderService encodeur) {
		
		this.encodeur = encodeur;
	}


	public Boolean login(LoginInputs inputs) {

//		email = email.trim();
//		Regex
		
		String mdpcryp = env.getProperty("adminLogin");

		
		boolean ok = encodeur.verifier(inputs.getKeyLog(), mdpcryp);
		
		

		


		return ok;

	}

}
