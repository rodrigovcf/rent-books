package com.rentbooks.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

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
		//final String defaultUser = "/default";
		final String defaultUser = "/admin/home";
		
		

		http.formLogin()
					.loginPage(login)
					.loginProcessingUrl(login)
					.defaultSuccessUrl(defaultUser)
					.usernameParameter("name")
					.passwordParameter("password")
					.and()
					.authorizeRequests()
					.anyRequest().permitAll();
		
//		.authorizeUrls()
//        .antMatchers("/signup","/about").permitAll() // #4
//        .antMatchers("/admin/**").hasRole("ADMIN") // #6
//        .anyRequest().authenticated() // 7
//        .and()
//    .formLogin()  // #8
//        .loginUrl("/login") // #9
//        .permitAll(); // #5
		
		
		
//		http.formLogin().usernameParameter("name");
//
//		http.authorizeRequests().antMatchers(login).permitAll();
//		
//		http.formLogin().loginPage(login).defaultSuccessUrl(defaultUser);
	
	}


}
