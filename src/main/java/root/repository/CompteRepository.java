package root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import root.entites.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer>{

}
