package com.idat.ec3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@SuppressWarnings("deprecation")
@EnableAuthorizationServer
@Configuration
public class Auth2Config extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private TokenStore store;
	
	@Autowired
	private AuthenticationManager authentication;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {


		clients.inMemory() // en memoria
		.withClient("prueba") // creando el usuario
		.secret( new BCryptPasswordEncoder().encode("prueba")   ) //contraseña encriptada
		.authorizedGrantTypes("password","authorization_code","refresh_token","implicit")
		.scopes("read","whrite","trust") // el token va escribir, lee, y tendra confianza
		.accessTokenValiditySeconds(60*60*1) //tiempo de duracion, en este caso 1hora
		.refreshTokenValiditySeconds(60*60*2);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {


		endpoints.tokenStore(store)
		.authenticationManager(authentication);
	}
	
	

}
