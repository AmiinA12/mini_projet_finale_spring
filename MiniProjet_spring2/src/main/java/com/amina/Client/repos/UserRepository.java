package com.amina.Client.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amina.Client.entity.*;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
