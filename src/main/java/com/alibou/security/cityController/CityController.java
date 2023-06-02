package com.alibou.security.cityController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibou.security.CityService.CityServiceInterface;
import com.alibou.security.cityEntity.CityEntity;

@RestController
@RequestMapping("/api/v1/citysearch")
public class CityController {

	@Autowired
	private CityServiceInterface cityServiceInterface;

	@GetMapping
	ResponseEntity<List<CityEntity>> saerchApi(@RequestParam("username") String cityname) {

		cityServiceInterface.searchProduct(cityname);

		return ResponseEntity.ok(cityServiceInterface.searchProduct(cityname));

	}

}
