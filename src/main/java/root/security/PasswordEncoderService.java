package root.security;

public interface PasswordEncoderService {

	public String hasher(String password);

	public boolean verifier(String password, String hash);

}
