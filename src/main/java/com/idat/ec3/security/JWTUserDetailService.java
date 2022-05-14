package com.idat.ec3.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.idat.ec3.models.UsuarioCliente;
import com.idat.ec3.repositories.UsuarioClienteRepository;

@Service
public class JWTUserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioClienteRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UsuarioCliente usuario = repository.findByUsuario(username);

		if (usuario != null) {
			List<GrantedAuthority> listaGranted = new ArrayList<GrantedAuthority>();
			GrantedAuthority granted = new SimpleGrantedAuthority(usuario.getRol());

			listaGranted.add(granted);
			return new User(usuario.getUsuario(), new BCryptPasswordEncoder().encode(usuario.getPassword()),
					listaGranted);

		} else {
			throw new UsernameNotFoundException("El usuario no existe");
		}
	}

}
