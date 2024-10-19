package com.shoppingcartpoc.config;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shoppingcartpoc.jwt.JwtAuthenticationFilter;
import com.shoppingcartpoc.jwt.JwtAuthorizationFilter;
import com.shoppingcartpoc.repository.UserRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailsService;

	private UserRepository userRepository;
	
	public SecurityConfig(UserRepository userRepository) {
		super();

		this.userRepository = userRepository;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	private static final String[] ADMIN_PATHS= {
			"/api/user/**",
			"/api/cart/**",
			"/api/order/**",
			"/api/product/**"
			
	};
	private static final String[] PUBLIC_PATHS= {
			"/api/user/signUp",
			"/api/usersAccess/products/all"
			
	};
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
		.addFilter(new JwtAuthenticationFilter(authenticationManager()))
        .addFilter(new JwtAuthorizationFilter(authenticationManager(),  this.userRepository))
        .authorizeRequests()
		.antMatchers(HttpMethod.POST,"/login").permitAll()
		.antMatchers(PUBLIC_PATHS).permitAll()
		.antMatchers(ADMIN_PATHS).hasRole("ADMIN")
		.antMatchers("/api/usersAccess/**")
        .hasAnyRole("USERS","ADMIN").and().httpBasic();	
	
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


}
