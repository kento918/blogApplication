package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityComfiguration {
	
	@Autowired
	customLoginSuccessHandler customLoginSuccessHandler;
	
	@Autowired
	customLoginFailureHandler customLoginFailureHandler;

	@Autowired
	customLogoutSuccessHandler customLogoutSuccessHandler;
	
	@Autowired
	private MyUserDetailsService us;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception{
		return https
				.csrf(cs -> cs.disable())
				.authorizeHttpRequests(registry->{
					registry.requestMatchers("/").permitAll();
					registry.requestMatchers("/login").permitAll();
					registry.requestMatchers("/logout").permitAll();
					registry.requestMatchers("/registUser").permitAll();
					registry.requestMatchers("/admin/**").hasRole("admin");
					registry.requestMatchers("/user/**").hasRole("user");
					registry.requestMatchers("/css/**").permitAll();
					registry.requestMatchers("/js/**").permitAll();
					
					registry.anyRequest().authenticated();
				})
				.formLogin(auth -> {
					auth.loginPage("/login").permitAll();
					auth.successHandler(customLoginSuccessHandler);
					auth.failureHandler(customLoginFailureHandler);
				})
				.logout(log ->{
					log.logoutUrl("/logout");
					log.logoutSuccessHandler(customLogoutSuccessHandler);
				})
				
				
		.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return us;
	}
	
	@Bean
	public AuthenticationProvider authProvider() {
		 DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		 provider.setUserDetailsService(userDetailsService());
		 provider.setPasswordEncoder(passwordEncoder());
		 return provider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
