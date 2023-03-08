package root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import root.entites.Champion;

public interface ChampionRepository extends JpaRepository<Champion, Integer>{

}
