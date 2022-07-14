package com.rentbooks.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private ImplementsUserDetailsService userDetails;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		
		auth.inMemoryAuthentication()
				.withUser("admin").password("admin123").roles("ADMIN");
		
		auth.userDetailsService(userDetails);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		final String login = "/login";
		
		http.formLogin().usernameParameter("name");
		
		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*viewallbook*/**").access("hasRole('USER') or hasRole('ADMIN')").and()
		.formLogin().loginPage(login);
		
		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*addbook*/**").access("hasRole('ADMIN')").and()
		.formLogin().loginPage(login);
		
		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*status*/**").access("hasRole('USER')").and()
		.formLogin().loginPage(login);
		
		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*home*/**").access("hasRole('USER') or hasRole('ADMIN')").and()
		.formLogin().loginPage(login);
	
	}
	
	public void configure(WebSecurity web)throws Exception {
		web.ignoring().antMatchers("../webjars/**");
		web.ignoring().antMatchers("../resources/**");
	}

}
