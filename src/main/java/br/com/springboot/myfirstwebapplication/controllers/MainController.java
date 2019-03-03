package br.com.springboot.myfirstwebapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String main(Model model) {
		
		model.addAttribute("msn", "esta é uma mensagem do meu controller");
		
		return "index";
	}
	
}
