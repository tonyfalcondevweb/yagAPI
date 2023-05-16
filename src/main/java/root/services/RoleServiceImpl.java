package root.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import root.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService {
	
	private RoleRepository RoleRep;
	
	@Autowired
	public RoleServiceImpl (RoleRepository RoleRep) {
		this.RoleRep = RoleRep;
	}

}
