package com.centrodistribuccion.pra.util;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    protected void configure(HttpSecurity http) throws Exception {

		//todo: cambiar configuracion, esta no se debe utilizar en produccion
		
        http.authorizeRequests()
        	.antMatchers("/**").permitAll()
        	.antMatchers("/h2_console/**").permitAll()
        	.anyRequest().authenticated().and().csrf().disable();
        
        http.headers().frameOptions().disable();
    }
}
