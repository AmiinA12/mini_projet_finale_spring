package com.amina.Client.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.amina.Client.entity.Client;

import com.amina.Client.repos.*;

@Service
public class ClientServiceImpl implements ClientService {
	
	 @Autowired
	    private ClientRepository clientRepository;

	 
	 @Override
	 public Client saveClient(Client c) {
	 	return clientRepository.save(c);
	 	}
	 	@Override
	 	public Client updateClient(Client cl) {
	 	return clientRepository.save(cl);
	 	}
	 	@Override
	 	public void deleteClient(Client c) {
	 		clientRepository.delete(c);
	 	}
	 	 @Override
	 	public void deleteClientById(Long id) {
	 		clientRepository.deleteById(id);
	 	}
	 	@Override
	 	public Client getClient(Long id) {
	 	return clientRepository.findById(id).get();
	 	}
	 	@Override
	 	public List<Client> getAllClient() {
	 	return clientRepository.findAll();
	 	}
	 	@Override
	 	public Page<Client> getAllClientsParPage(int page, int size) {
	 		return clientRepository.findAll(PageRequest.of(page, size));
	 	}
		@Override
		public List<Client> findClientbyID(Long idCom) {
			return clientRepository.findClientbyID(idCom);
		}		
	

		
	
		
		
	 	
	
}
