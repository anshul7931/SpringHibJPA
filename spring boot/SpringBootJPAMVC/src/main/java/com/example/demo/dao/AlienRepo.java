package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
	//JpaRepository extends PagingAndSortingRepository which further extends CrudRepository
	
	List<Alien> findByTech(String tech);  /*These are the naming convention to search on basis 
											*of custom query.
											*It should be like findBy<Name of attribute>
											*/
	/*We have multiple naming conventions for all attributes
	 * 1. findBy<Name of attribute>(attribute)
	 * 2. findBy<Name of attribute>GreaterThan(attribute)
	 * 3. findBy<Name of attribute>LessrThan(attribute)
	 * 
	 * We can also write our custom queries
	*/
	
	@Query("from Alien where tech=?1 order by aname desc")
	List<Alien> findByTechSorted(String tech);

}
