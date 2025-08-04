package com.idat.semana8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.semana8.entidad.Usuario;
import com.idat.semana8.service.IUsuarioService;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

	@Autowired
	private IUsuarioService service;

	@GetMapping("/{email}")
	public Usuario buscarEmail(@PathVariable("email") String email) {

		return service.buscarEmail(email);
	}

	@GetMapping("/listar")
	public List<Usuario> lista() {
		return service.listarUsuario();
	}

}
