package com.sooyoung.springbootadvanced.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
    @Override
    public void commence(final HttpServletRequest request, 
            final HttpServletResponse response, 
            final AuthenticationException authException) throws IOException, ServletException {
        //Authentication failed, send error response.
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
         
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 : you have fucked up!! " + authException.getMessage());
    }
    
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("TEST REALM");
	}

}
