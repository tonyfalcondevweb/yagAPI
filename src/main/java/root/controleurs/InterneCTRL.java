package root.controleurs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import root.inputs.LoginInputs;
import root.inputs.LoginResponse;
import root.services.InterneService;

@RestController
public class InterneCTRL {
	
	@Autowired
	private InterneService interneServ;
	

	
	
	@PostMapping("/yagAPI/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginInputs inputs){
		
		try {
			
			LoginResponse lr = interneServ.login(inputs.getNom(), inputs.getInterneKey());
			

			return ResponseEntity.ok(lr);
		
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, ex.getMessage());
		}
			
	}	

}
