package com.idat.semana8.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.semana8.dao.IUsuarioDao;
import com.idat.semana8.entidad.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
    private IUsuarioDao dao;

    @Override
    public Usuario buscarEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public Optional<String> buscarSession() {
        // Esto viene de tu clase SeguridadUtil
        return Optional.ofNullable(com.idat.semana8.util.SeguridadUtil.getCurrentUser());
    }

    @Override
    public List<Usuario> listarUsuario() {
        return dao.findAll();
    }

  
}

