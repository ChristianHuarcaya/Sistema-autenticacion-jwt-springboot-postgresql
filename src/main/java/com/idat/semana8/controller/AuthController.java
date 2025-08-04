package com.idat.semana8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.semana8.dto.JwtResponse;
import com.idat.semana8.dto.LoginRequest;
import com.idat.semana8.dto.util.JwtUtil;
import com.idat.semana8.entidad.Usuario;
import com.idat.semana8.service.IUsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getClave()));

			SecurityContextHolder.getContext().setAuthentication(authentication);

			Usuario usuario = usuarioService.buscarEmail(loginRequest.getEmail());

			String token = jwtUtil.generarToken(usuario.getEmail(), usuario.getRol());

			return ResponseEntity.ok(new JwtResponse(token, usuario.getEmail(), usuario.getRol()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
		}
	}

}
