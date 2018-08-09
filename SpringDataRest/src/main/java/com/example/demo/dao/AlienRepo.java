package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Alien;

//Only this repository is getting used, no controller is needed


@RepositoryRestResource(collectionResourceRel="aliens",path="aliens")
public interface AlienRepo extends JpaRepository<Alien, Integer> {

	/*
	 * For getAll  -> localhost:8070/aliens (It will also provide getById links) (GET)
	 * For getById -> localhost:8070/aliens/<aid> (GET)
	 * For create  -> localhost:8070/aliens (POST)--Pass JSON
	 * For Update  -> localhost:8070/aliens (PUT)--Pass JSON
	 * For Delete  -> localhost:8070/aliens/<aid> (DELETE)
	*/
}
