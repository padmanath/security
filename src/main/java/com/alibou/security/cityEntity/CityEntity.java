package com.alibou.security.cityEntity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
@Table(name="City5000")
public class CityEntity {
	
	
	@Id
	private String POPULATION;
	
	private String CITYNAMES;
	
	private String LATITUDE;
	
	private String LONGITUDE;
	
	private String CODE;
	
	private String REGION;
	

}
