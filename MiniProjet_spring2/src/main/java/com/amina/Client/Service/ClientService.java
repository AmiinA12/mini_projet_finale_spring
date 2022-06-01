package com.amina.Client.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.amina.Client.entity.*;

public interface ClientService {
	
		Client saveClient(Client c);
		Client updateClient(Client cl);
		void deleteClient(Client c);
		 void deleteClientById(Long id);
		Client getClient(Long id);
		List<Client> getAllClient();
		Page<Client> getAllClientsParPage(int page, int size);
		List<Client>findClientbyID(Long idCom);
		
		
}


