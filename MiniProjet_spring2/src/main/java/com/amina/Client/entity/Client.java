package com.amina.Client.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Client {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idClient;

@NotNull
@Size (min = 4,max = 15)
private String nomClient;


@NotNull
@Size (min = 8,max = 8)
private String telephone;

@ManyToOne
private Commande commande;
public Client() {
super();
}
public Client(Long idClient, @NotNull @Size(min = 4, max = 15) String nomClient, @Min(10) @Max(10000) @NotNull @Size(min = 8, max = 8) String telephone) {
	super();
	this.idClient = idClient;
	this.nomClient = nomClient;
	this.telephone = telephone;
}

public Commande getCommande() {
	return commande;
}
public void setCommande(Commande commande) {
	this.commande = commande;
}

public Long getIdClient() {
	return idClient;
}
public void setIdClient(Long idClient) {
	this.idClient = idClient;
}
public String getNomClient() {
	return nomClient;
}
public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}
public @NotNull @Size(min = 8, max = 8) String getTelephone() {
	return telephone;
}
public void setTelephone(@NotNull @Size(min = 8, max = 8) String telephone) {
	this.telephone = telephone;
}
@Override
public String toString() {
	return "Client [idClient=" + idClient + ", nomClient=" + nomClient + ", telephone=" + telephone + "]";
}


}


