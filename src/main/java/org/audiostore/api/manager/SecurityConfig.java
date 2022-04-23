package org.audiostore.api.manager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Configuration
public class SecurityConfig {
	@Bean
	 SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    return http.csrf().disable()
	      .requiresChannel(channel -> 
	          channel.anyRequest().requiresSecure())
	      .authorizeRequests(authorize ->
	          authorize.anyRequest().permitAll())
	      .build();
	    }
	

}
