package com.anshul.src;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface AlienRepository extends CrudRepository<Alien, Integer>{

}
