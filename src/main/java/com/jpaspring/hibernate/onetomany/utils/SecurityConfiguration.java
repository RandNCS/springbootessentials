package com.jpaspring.hibernate.onetomany.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
//public class SecurityConfiguration /* extends WebSecurityConfigurerAdapter */{
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements ApplicationContextAware {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder());

		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable);
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/api", "/ignore2");
	}

	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	 * throws Exception { http.authorizeRequests(authorizeRequests ->
	 * authorizeRequests.anyRequest() .permitAll())
	 * .csrf(AbstractHttpConfigurer::disable); return http.build(); }
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().
	 * formLogin().loginPage("/")
	 * .permitAll().and().logout().invalidateHttpSession(true).clearAuthentication(
	 * true) .logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout")).logoutSuccessUrl("/logout-success")
	 * .permitAll(); }
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http .httpBasic().and() .authorizeRequests() .antMatchers(HttpMethod.POST,
	 * "/api").hasRole("ADMIN") .antMatchers(HttpMethod.PUT,
	 * "/api/**").hasRole("ADMIN") .antMatchers(HttpMethod.PATCH,
	 * "/api/**").hasRole("ADMIN").and() .csrf().disable(); }
	 */

}
