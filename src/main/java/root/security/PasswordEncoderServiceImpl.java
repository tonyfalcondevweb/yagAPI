package root.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderServiceImpl implements PasswordEncoderService {

	private BCryptPasswordEncoder passwordEncoder;

	public PasswordEncoderServiceImpl() {
		passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public String hasher(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public boolean verifier(String password, String hash) {
		return passwordEncoder.matches(password, hash);
	}

}
