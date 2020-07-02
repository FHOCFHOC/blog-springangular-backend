package com.corinto.service;

import com.corinto.model.Usuario;
import com.corinto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepositorio;

    @Override
    public UserDetails loadUserByUsername(String nomeDoUsuario) throws UsernameNotFoundException {
        Usuario user = userRepositorio.findByNomeDoUsuario(nomeDoUsuario).orElseThrow(() ->
                new UsernameNotFoundException("Nenhum usuário foi encontrado " + nomeDoUsuario));
        return new org.springframework.security.core.userdetails.User(user.getNomeDoUsuario(),
                user.getSenha(),
                true, true, true, true,
                getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
        return Collections.singletonList(new SimpleGrantedAuthority(role_user));
    }
}
