package com.alibou.security.cityEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<CityEntity, String> {

	@Query(value ="SELECT * "
			+ " FROM city5000 c WHERE "+"c.citynames LIKE CONCAT( :cityname,'%')",
			nativeQuery=true)
	List<CityEntity> searchByCity(String cityname);
	
}
