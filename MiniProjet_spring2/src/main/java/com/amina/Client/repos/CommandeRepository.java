package com.amina.Client.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amina.Client.entity.*;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long>{

}