package root.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import root.entites.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {
	
	
	
	@Query("select t from Token t where t.tokenKey = :paramKey")
	public Optional<Token> selectByKey(@Param("paramKey") String key);	

}
