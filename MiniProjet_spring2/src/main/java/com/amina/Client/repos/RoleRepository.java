package com.amina.Client.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.amina.Client.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>  {

}
