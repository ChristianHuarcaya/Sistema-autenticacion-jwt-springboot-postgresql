package com.idat.semana8.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.semana8.entidad.Usuario;
import com.idat.semana8.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private IUsuarioService service;

	@GetMapping
	public ResponseEntity<?> bienvenido() {
		Optional<String> optSession = service.buscarSession();

		if (!optSession.isPresent()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		Usuario usu = service.buscarEmail(optSession.get());

		if (usu == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok("Bienvenido Usuario: " + usu.getNombre() + " " + usu.getApellido());
	}
}
