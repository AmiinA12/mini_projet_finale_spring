package com.amina.Client.Service;

import java.util.List;

import com.amina.Client.entity.Role;



public interface RoleService {
	 List <Role> findAll();
	    
	 Role saveRole(Role r);
	 Role updateRole(Role r);
	     Role getRole (Long idRole);
}
