package com.ecrops.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MroRibbonController {
	
	@GetMapping("/villseclist")
	public String getVillSecList(HttpSession httpSession, Model model) {
		return "Rep_VillSecListMaoIntf";
	}
	

	@GetMapping("/vaadet")
	public String getVaaList(Model model) {
		return "Rep_VAADetails";
	}
}
