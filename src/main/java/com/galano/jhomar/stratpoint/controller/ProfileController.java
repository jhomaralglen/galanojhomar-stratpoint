package com.galano.jhomar.stratpoint.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.galano.jhomar.stratpoint.model.Profile;
import com.galano.jhomar.stratpoint.service.ProfileServiceImpl;

@Controller
public class ProfileController {
	
	private static final Logger logger = LoggerFactory.getLogger(Profile.class);
	
	@Autowired
	ProfileServiceImpl profileService;
	
	@GetMapping("/") // If "/" is accessed, will redirect to "/home"
	public String index(){
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home(Model model){
		
		String viewName = "home";
		
		try {
			Profile[] profiles = profileService.getAllProfile();
			model.addAttribute("profiles", profiles);
			
		} catch (Exception e) {
			logger.info("Something went wrong in fetching Profiles");
			viewName = "error";
			
		}
		
		return viewName;
	}
	
	@GetMapping("/view")
	public String view(String id, Model model){
		String viewName = "profile";
		
		try {
			Profile[] profiles = profileService.getAllProfile();
			
			Profile profile = new Profile();
			for (Profile prof : profiles) {
				if(prof.getId().equals(id)){
					profile = prof;
					break;
				}
			}
			
			model.addAttribute("profile", profile);
			
		} catch (Exception e) {
			
			logger.info("Something went wrong in fetching Profiles");
			viewName = "error";
			
		}
		
		return viewName;
	}
	
	
}
