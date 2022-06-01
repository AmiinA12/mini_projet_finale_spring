package com.amina.Client.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amina.Client.entity.*;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("select o from Client o where o.commande.idCom like :idCom" )
	List<Client> findClientbyID(@Param("idCom") Long idCom);
	
	


}


