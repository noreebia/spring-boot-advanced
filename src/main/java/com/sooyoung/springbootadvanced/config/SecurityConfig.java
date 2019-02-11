package com.sooyoung.springbootadvanced.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService customUserDetailsService;
	
	@Autowired
	BasicAuthenticationEntryPoint authenticationEntryPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().authenticationEntryPoint(authenticationEntryPoint).and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
//		http.authorizeRequests().
//		anyRequest().authenticated()
//
//		
//		
//		.and()
//		.httpBasic().authenticationEntryPoint(authenticationEntryPoint)
//		
//		.and()
//		.csrf().disable().
//		
//		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
//		authorizeRequests()
//		.antMatchers("/", "/exception/**","/swagger-ui.html").permitAll().and().

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.userDetailsService(customUserDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
}
