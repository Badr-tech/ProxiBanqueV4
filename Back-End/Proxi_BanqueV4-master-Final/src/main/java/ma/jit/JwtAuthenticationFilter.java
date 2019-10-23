package ma.jit;

import java.sql.Date;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ma.jit.entities.Users;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private  AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

    }

    @Override
    public org.springframework.security.core.Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        Users appUser=null;
        try
        {
        	appUser= new ObjectMapper().readValue(request.getInputStream(), Users.class);
        	   	
        }
        catch(Exception e)
        {
        	throw new RuntimeException();
        }
        System.out.print("username:" +appUser.getLogin());
        System.out.print("password:" + appUser.getPassword());
        return authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(appUser.getLogin(), appUser.getPassword()));
        
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
    		org.springframework.security.core.Authentication authResult) throws java.io.IOException, ServletException 
    {
        User springUser  = (User) authResult.getPrincipal();
        
        String  token = Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, SecurityConstants.JWT_SECRET)
            .setSubject(springUser.getUsername())
            .setExpiration(new Date(System.currentTimeMillis() + 864000000))
            .claim("roles", springUser.getAuthorities())
            .compact();

        response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token);
        super.successfulAuthentication(request, response, chain, authResult);
    }

}
