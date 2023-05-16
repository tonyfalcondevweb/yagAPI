package root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import root.entites.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
