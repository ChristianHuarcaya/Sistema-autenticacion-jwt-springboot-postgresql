package com.idat.semana8.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola")
public class HolaController {

	@GetMapping
	public ResponseEntity<?> hola() {

		return ResponseEntity.ok("Bienvenido a spring security");
	}

}
