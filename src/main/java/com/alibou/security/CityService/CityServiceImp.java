package com.alibou.security.CityService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibou.security.cityEntity.CityEntity;
import com.alibou.security.cityEntity.CityRepository;

@Service
public class CityServiceImp implements CityServiceInterface {

	private CityRepository cityRepository;

	public CityServiceImp(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}

	@Override
	public List<CityEntity> searchProduct(String cityname) {
		// TODO Auto-generated method stub
        List<CityEntity> searchByCity = cityRepository.searchByCity(cityname);
		return searchByCity;
	}

}
