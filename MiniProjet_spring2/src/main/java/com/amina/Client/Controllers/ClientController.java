package com.amina.Client.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amina.Client.entity.*;
import com.amina.Client.Service.ClientService;
import com.amina.Client.Service.CommandeService;

@Controller
public class ClientController {
	@Autowired
	ClientService clService;
	@Autowired
	CommandeService comService;

	@RequestMapping("/saveClient")
	public String saveClient(@Valid Client cl, BindingResult bindingResult) {
		System.out.println(cl);
		System.out.println(bindingResult.getAllErrors());
		if (bindingResult.hasErrors())
			return "formClient";
		clService.saveClient(cl);
		return "redirect:/ListeClient";
	}
	

	/*@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Commande> com = comService.findAll();
		
		modelMap.addAttribute("client", new Client());
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("commandes", com);
		return "formClient";
	}*/
	@RequestMapping("/showCreate")
	public String showCreatePosts(ModelMap modelMap) {
		List<Commande> coms =  comService.findAll();
		Client pos = new Client();
		Commande com = new Commande();
		com = coms.get(0); // prendre la première catégorie de la liste
		pos.setCommande(com); // affedter une catégorie par défaut au produit pour éviter le pb avec une// catégorie null
		modelMap.addAttribute("client", pos);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("commandes", coms);
		return "formClient";
	}

	@RequestMapping("/ListeClient")
	public String ListeClient(ModelMap modelMap, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "3") int size) {
		Page<Client> clis = clService.getAllClientsParPage(page, size);
		modelMap.addAttribute("client", clis);
		modelMap.addAttribute("pages", new int[clis.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeClients";
	}


	@RequestMapping("/supprimerClient")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		clService.deleteClientById(id);
		Page<Client> clis = clService.getAllClientsParPage(page, size);
		modelMap.addAttribute("clients", clis);
		modelMap.addAttribute("pages", new int[clis.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeClients";
	}

	@RequestMapping("/modifierClient")
	public String editerClient(@RequestParam("id") Long id, ModelMap modelMap) {
		Client p = clService.getClient(id);
		System.out.println(p);
		List<Commande> cat = comService.findAll();
		 cat.remove(p.getCommande());
		modelMap.addAttribute("commandes", cat);
		modelMap.addAttribute("client", p);
		modelMap.addAttribute("mode", "edit");
		System.out.println(p);
		return "formClient";
	}

@RequestMapping("/RechercherClient")
	public String searchClient(ModelMap modelMap, @Valid Long idCom) {
		List<Client> clients = clService.findClientbyID(idCom);
		modelMap.addAttribute("clients", clients);
		return "/RechercherClients";
	}

	@RequestMapping("/updateClient")
	public String updateClient(@ModelAttribute("client") Client client, ModelMap modelMap) throws ParseException {
		clService.updateClient(client);
		System.out.println(client);
		List<Client> cli = clService.getAllClient();
		modelMap.addAttribute("clients", cli);
		return "redirect:/listeClients";
	}


}
