package com.alibou.security.CityService;

import java.util.List;

import com.alibou.security.cityEntity.CityEntity;

public interface CityServiceInterface  {

	List<CityEntity> searchProduct(String cityname);
	
}
