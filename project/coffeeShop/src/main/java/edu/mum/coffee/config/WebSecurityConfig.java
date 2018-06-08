package edu.mum.coffee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static String REALM="COFFESHOP";
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/signup", "/login", "/webjars/**", "/css/**", "/images/**").permitAll();
		http.csrf().disable();
		http.headers().frameOptions().disable();
	
		http.authorizeRequests().antMatchers("/products/**",
				"/product/**", "/person/**", "/persons/**", "/orders/**").hasRole("ADMIN").and().httpBasic()
			.realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint());

		http.authorizeRequests().antMatchers("/placeOrder", "/my-account").authenticated();

		http.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll();
    }
	
	@Bean
	public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
		return new CustomBasicAuthenticationEntryPoint();
	}
}