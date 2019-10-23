package ma.jit;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
@Configuration
@EnableWebSecurity
public class BanqueSecurite extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailService;
	@Autowired
	private BCryptPasswordEncoder bCryptPassword;
	@Autowired
	public void configuration(AuthenticationManagerBuilder auth,DataSource data) throws Exception
	{
		 
		
		
		auth.userDetailsService(userDetailService).passwordEncoder(bCryptPassword);
		
	
	
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	http
         .cors().and().csrf().disable()
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**").permitAll();
        http.authorizeRequests().antMatchers("/virement/**").hasRole("conseiller");
        http.authorizeRequests().antMatchers("/parametrage/**").hasRole("backoffice");
        http.authorizeRequests().antMatchers("/gestion/**").hasRole("gerant");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JwtAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

       
		
	}
	
	@Bean
	   public CorsConfigurationSource corsConfigurationSource() {
	       CorsConfiguration configuration = new CorsConfiguration();
	       configuration.setAllowedOrigins(Arrays.asList("*"));
	       configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
	       configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
	       configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
	       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	       source.registerCorsConfiguration("/**", configuration);
	       return source;
	   }
	
}
