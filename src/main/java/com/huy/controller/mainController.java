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

	@GetMapping("/select001")
	public String select001(Model model) {
		model.addAttribute("items", itemrepository.select001("1"));
		return "select001";
	}

	@GetMapping("/select002")
	public String select002(Model model) {
		model.addAttribute("items", itemrepository.select002("1"));
		return "select002";
	}

	@GetMapping("/select003")
	public String select003(Model model) {
		model.addAttribute("item", itemrepository.select001("1").get(0));
		return "select003";
	}

	@GetMapping("/select004")
	public String select004(Model model) {
		model.addAttribute("item", itemrepository.select004(1));
		return "select004";
	}

}