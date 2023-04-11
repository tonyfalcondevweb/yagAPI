package root.controleurs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import root.inputs.LoginInputs;
import root.services.AdminService;

//@CrossOrigin(origins = "https://way-one.vercel.app/")
//@CrossOrigin(origins = "http://localhost:5173/")
@RestController
public class AdminCTRL {

	
	
	@Autowired
	private AdminService adminServ;
	
	
	
	@PostMapping("/yagAPI/post/loginAdmin")
	private Boolean auto (@RequestBody LoginInputs inputs) {
		
		
		Boolean auto = adminServ.login(inputs);
		
		System.out.println(auto);
		
		return auto;
	}
	
	
	
	
}
