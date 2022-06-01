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
public class CommandeController {
	@Autowired
	CommandeService ComService;
	
	@RequestMapping("/showCreateCom")
	public String showCreateCom(ModelMap modelMap)
	{
	modelMap.addAttribute("commandes", new Commande());
	modelMap.addAttribute("mode", "new");
	return "formCommande";
	}

	
	@RequestMapping("/saveCommande")
	public String saveCommande(@ModelAttribute("commandes")Commande commande,ModelMap modelMap) throws ParseException 
	{
	Commande saveCommande = ComService.saveCommande(commande);
	return "redirect:/ListeCom";
	}
	/*@RequestMapping("/ListeCom")
	public String listeCommande(ModelMap modelMap)
	{
	List <Commande> cats = ComService.findAll();
	modelMap.addAttribute("commandes", cats);
	return "ListeCom";
	}*/
	
	@RequestMapping("/ListeCom")
	public String showCreateCom(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
	@RequestParam(name = "size", defaultValue = "4") int size) {
	Page<Commande> cats = ComService.getAllCommandeParPage(page, size);
	modelMap.addAttribute("commandes", cats);
	modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeCom";
	}
	@RequestMapping("/supprimerCom")
	public String supprimerCommande(@RequestParam("id") Long id, ModelMap modelMap,
	@RequestParam(name = "page", defaultValue = "0" )int page,
	@RequestParam(name = "size", defaultValue = "3") int size) {
	ComService.deleteCommandeById(id);
	List<Commande> cats = ComService.findAll();
	modelMap.addAttribute("commandes", cats);
	return "listeCom";
	}
	

	@RequestMapping("/modifierCommande")
	public String modifierCommande(@RequestParam("id") Long id,ModelMap modelMap)
	{
	List<Commande> cat = ComService.findAll();
	Commande c= ComService.getCommande(id);
	System.out.println(c);
	modelMap.addAttribute("commandes", c);
	modelMap.addAttribute("mode", "edit");
	return "formCommande";
	}

	@RequestMapping("/updateCommande")
	public String updateCategorie(@ModelAttribute("commande") Commande commande,ModelMap modelMap) throws ParseException {
		ComService.updateCommande(commande);
		 List<Commande> cats = ComService.findAll();
		 modelMap.addAttribute("commandes", cats);
		return "ListeCom";
		}

}
