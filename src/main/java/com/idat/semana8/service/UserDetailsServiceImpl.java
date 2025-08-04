package com.idat.semana8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.semana8.dao.IUsuarioDao;
import com.idat.semana8.entidad.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
    private IUsuarioDao dao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = dao.findByEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + email);
        }

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getClave()) // Ya viene hasheada
                .roles(usuario.getRol())      // "ADMIN" o "USER", sin "ROLE_"
                .build();
    }
}


