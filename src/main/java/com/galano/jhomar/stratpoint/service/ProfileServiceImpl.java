package com.galano.jhomar.stratpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.galano.jhomar.stratpoint.model.Profile;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	RestTemplate restTemplate;
	
	
	@Value("${profile.api}") //Set value from application.properties
	private String profileUrlApi;
	
	@Override
	public Profile[] getAllProfile() {
		return restTemplate.getForObject(profileUrlApi, Profile[].class);
	}

}
