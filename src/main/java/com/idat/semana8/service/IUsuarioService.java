package com.idat.semana8.service;

import java.util.List;
import java.util.Optional;

import com.idat.semana8.entidad.Usuario;


public interface IUsuarioService {

	Usuario buscarEmail(String email);
	Optional<String> buscarSession();
	List<Usuario> listarUsuario();

}
