package kr.re.etri.advcloud.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import kr.re.etri.advcloud.common.jwt.UnauthorizedAuthenticationEntryPoint;
import kr.re.etri.advcloud.common.jwt.filter.JwtRequestFilter;
import kr.re.etri.advcloud.common.jwt.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);
	
	private static final String[] AUTH_WHITELIST = {
		"/resources/**",
		"/favicon.ico",
		"/api/datamanager/user/signup",
		"/api/datamanager/user/signin",
		"/api/datamanager/user/password-change",
		"/v2/api-docs",
		"/configuration/**",
		"/swagger*/**",
		"/webjars/**",
    };
	
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private UnauthorizedAuthenticationEntryPoint unauthorizedAuthenticationEntryPoint;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
    	// 
    	try {
        	super.configure(auth);
            auth.userDetailsService(customUserDetailsService);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Override
    public void configure(HttpSecurity security) {
    	// 
    	try {
    		security.cors().and()
	        .httpBasic().disable()
	        .formLogin().disable()
	        .csrf().disable()
	        .logout().disable();

    	security.authorizeRequests()
			.antMatchers(AUTH_WHITELIST)
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(unauthorizedAuthenticationEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        security.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() {
    	// 
    	try {
			return super.authenticationManager();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
    }
    
}
