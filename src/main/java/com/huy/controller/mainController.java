package com.huy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping("/save/{id}/{content}")
	public String save(@PathVariable int id, @PathVariable String content, RedirectAttributes redirect) {
		itemrepository.update001(id, content);
		return "redirect:/";
	}

}