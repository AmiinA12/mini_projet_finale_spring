package com.amina.Client.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.amina.Client.entity.*;

public interface CommandeService {
	  List <Commande> findAll();
	    
	    Commande saveCommande(Commande c);
	    Commande updateCommande(Commande c);
	    void deleteCommande(Commande c);
	     void deleteCommandeById(Long id);
	     Commande getCommande (Long idCom);


		List<Commande> getAllCommande();

		Page<Commande> getAllCommandeParPage(int page, int size);
}
