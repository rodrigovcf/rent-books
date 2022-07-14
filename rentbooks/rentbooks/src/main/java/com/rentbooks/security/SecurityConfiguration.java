package com.rentbooks.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private ImplementsUserDetailsService userDetails;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("ADMIN");

		auth.userDetailsService(userDetails).and().inMemoryAuthentication();

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		final String login = "/login";
		final String defaultUser = "/default";

		http.csrf().disable();
		
		http.formLogin().usernameParameter("name");

		http.authorizeRequests().antMatchers(login).permitAll();
		
		http.formLogin().loginPage(login).defaultSuccessUrl(defaultUser);
	
	}


}
