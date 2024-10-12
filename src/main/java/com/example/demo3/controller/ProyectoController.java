package com.example.demo3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo3.model.Subject;
import com.example.demo3.repository.ISubjectRepository;

@Controller
public class ProyectoController {
	@Autowired
	private ISubjectRepository repository;
	
	@GetMapping("/registrar")
	public String registrarSubject(@RequestParam(name = "name",required = false,defaultValue = "subject") String name, Model model) {
	
		Subject subj = new Subject();
		subj.setIdSubject(1);
		subj.setCode("code001");
		subj.setName("Lenguaje de programacion II");
		subj.setLevel("basico");
		subj.setTeacher("Jorge Ventura");
		
		subj = repository.save(subj);
		model.addAttribute("name", subj);
		return "registro";
	}
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("lista", repository.findAll());
		return "listado";
	}
	}
