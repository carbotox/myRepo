package com.radu.test.spring.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String USER_NAME = "user";
	public static final String USER_PASSWORD = "abc";
	private static final String USER_ROLE = "USER";

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
				.withUser(USER_NAME).password(USER_PASSWORD).roles(USER_ROLE);
	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/rest/**").hasRole("USER").and().csrf().disable().headers()
				.frameOptions().disable();
	}

	@Bean
	public HttpFirewall defaultFireWall() {
		DefaultHttpFirewall firewall = new DefaultHttpFirewall();
		firewall.setAllowUrlEncodedSlash(true);
		return firewall;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.httpFirewall(defaultFireWall());
		super.configure(web);
	}
}
