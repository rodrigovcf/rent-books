package com.rentbooks.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private ImplementsUserDetailsService userDetails;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetails).passwordEncoder(NoOpPasswordEncoder.getInstance());

		auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("ADMIN");



	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		final String login = "/login";

//		http.formLogin()
//		.loginPage(login)
//		.loginProcessingUrl(login)
//		.usernameParameter("name")
//		.passwordParameter("password")
//		.successHandler(new AuthenticationSuccessHandler() {
//
//			@Override
//			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//					Authentication authentication) throws IOException, ServletException {
//				String name = authentication.getName();
//				if (name.equals("admin")) {
//					response.sendRedirect("/admin/home");
//				}else
//					response.sendRedirect("/Renter/home");
//
//			}
//		})
//
//		.and()
//		.logout().permitAll().and()
//		.authorizeRequests()
//		.anyRequest().permitAll();
//
//		http.csrf().disable();



		
		


		final String hasRoleADMIN = "hasRole('ADMIN')";
		final String hasRoleUSER = "hasRole('USER')";

		http.formLogin().usernameParameter("name").passwordParameter("password")
			.successHandler(new AuthenticationSuccessHandler() {

				@Override
				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
					String name = authentication.getName();
					if (name.equals("admin")) {
						response.sendRedirect("/admin/home");
					}else
						response.sendRedirect("/Renter/home");
	
				}
			});

		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*admin/viewallbook*/**").access(hasRoleADMIN).and()
		.formLogin().loginPage(login).loginProcessingUrl(login);

		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*Renter/viewallbook*/**").access(hasRoleUSER).and()
		.formLogin().loginPage(login).loginProcessingUrl(login);

		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*admin/*addbook*/**").access(hasRoleADMIN).and()
		.formLogin().loginPage(login).loginProcessingUrl(login);

		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*admin/update*/**").access(hasRoleADMIN).and()
		.formLogin().loginPage(login).loginProcessingUrl(login);

		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*Renter/status*/**").access(hasRoleUSER).and()
		.formLogin().loginPage(login).loginProcessingUrl(login);

		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*admin/home*/**").access(hasRoleADMIN).and()
		.formLogin().loginPage(login).loginProcessingUrl(login);

		http.authorizeRequests().antMatchers(login).permitAll()
		.antMatchers("/", "/*Renter/home*/**").access(hasRoleUSER).and()
		.formLogin().loginPage(login).loginProcessingUrl(login);
		
		//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.csrf().disable();


	}
	
	@Bean
	public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}


}
