package com.ty.ecom.basepack.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AppplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()                                                                                                           //s8       // waiting for tutorial this concept
		.authorizeHttpRequests()
		.antMatchers("/").permitAll()                                                                                               //antMacher-> it is path pattern
		                                                                                                                            //authenticate filter(1 of 6 filter)-> used to skip css jss path
	    .antMatchers("/api/**").hasRole(ApplicationUserRoles.STUDENT.name())    
	     .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.name())                                                                                                                            //s6            ///make hasrole based () authenticate for std or admin 
	     .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.name())                                                                                                                            //s6            ///make hasrole based () authenticate for std or admin 
	     .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.name())                                                                                                                            //s6            ///make hasrole based () authenticate for std or admin 
	     .antMatchers(HttpMethod.GET,"/management/api/**").hasAnyRole(ApplicationUserRoles.ADMIN.name(),ApplicationUserRoles.ADMINTRAINEE.name())                                                                                                                    //s6            ///make hasrole based () authenticate for std or admin 
		.anyRequest()
		.authenticated()
		.and().
		httpBasic();                                                                              
		                                                                                          

	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails padmanathanUser = User.builder()
				.username("padmanathan")                                                        //s1
				.password(passwordEncoder.encode("password"))                                   //s2(normal password)  s3(encoder)
				.roles(ApplicationUserRoles.STUDENT.name())                                     //s4(normal role)  s5(applicationrole)     
				.build();
		
       UserDetails lindaUser = User.builder()
    		   .username("linda")
    		   .password(passwordEncoder.encode("passwoed123"))
    		   .roles(ApplicationUserRoles.ADMIN.name())
    		   .build();
       
       UserDetails tomUser = User.builder()
    		   .username("tom")
    		   .password(passwordEncoder.encode("passwoed1234"))
    		   .roles(ApplicationUserRoles.ADMINTRAINEE.name())                              //s7 management control
    		   .build();
		
		return new InMemoryUserDetailsManager(padmanathanUser,lindaUser,tomUser);              //ref storing ensure it always

	}

}
