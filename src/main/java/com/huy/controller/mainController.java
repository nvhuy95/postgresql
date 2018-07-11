package com.huy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.huy.repository.ItemRepository;

@Controller
public class mainController {

	@Autowired
	ItemRepository itemrepository;

	@GetMapping("/")
	public String note(Model model) {
		model.addAttribute("items", itemrepository.select001());
		return "index";
	}

}