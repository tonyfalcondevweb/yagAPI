package root.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import root.entites.Champion;

public interface ChampionRepository extends JpaRepository<Champion, Integer>{


	@Query(value ="SELECT p.nom, p.id_champion as idChampion,"
			+ " p.key_riot as keyRiot, count(c.id_champion) as total "
			+ "FROM champion p join compte c on p.id_champion = c.id_champion "
			+ "group by c.id_champion ORDER BY total DESC LIMIT 10", nativeQuery = true)
	List<Map<String, Object>> findAllByGroupingProperty();
}
