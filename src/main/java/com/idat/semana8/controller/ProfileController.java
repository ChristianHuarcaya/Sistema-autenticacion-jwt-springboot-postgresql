package com.idat.semana8.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.semana8.entidad.Usuario;
import com.idat.semana8.service.IUsuarioService;
import com.idat.semana8.util.SeguridadUtil;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private IUsuarioService service;

    @GetMapping
    public ResponseEntity<Map<String, String>> bienvenido() {
        String session = SeguridadUtil.getCurrentUser();

        if (session == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Acceso denegado: sesión no encontrada"));
        }

        Usuario usu = service.buscarEmail(session);

        if (usu == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Usuario no encontrado"));
        }

        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Bienvenido " + usu.getNombre() + " " + usu.getApellido());
        response.put("rol", usu.getRol());
        response.put("email", usu.getEmail());

        return ResponseEntity.ok(response);
    }
}
