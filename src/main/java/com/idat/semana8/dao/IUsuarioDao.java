package com.idat.semana8.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.semana8.entidad.Usuario;

public interface IUsuarioDao  extends JpaRepository<Usuario,Long>{
	
	Usuario findByEmail(String email);

}
