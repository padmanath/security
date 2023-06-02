package com.alibou.security.auth;

import com.alibou.security.config.JwtService;
import com.alibou.security.token.Token;
import com.alibou.security.token.TokenRepository;
import com.alibou.security.token.TokenType;
import com.alibou.security.user.Role;
import com.alibou.security.user.User;
import com.alibou.security.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
  private final UserRepository repository; //ok
  private final PasswordEncoder passwordEncoder;//ok
  private final JwtService jwtService; //ok
  private final AuthenticationManager authenticationManager; //ok
  private final TokenRepository tokenRepository;
  public AuthenticationResponse register(RegisterRequest request) {  //ok
	  
    var user = User.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
//        .role(Role.USER)
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    
   
    return AuthenticationResponse.builder()
        .token(jwtToken)
            
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) { //ok
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

//  private void saveUserToken(User user, String jwtToken) {
//	    var token = Token.builder()
//	        .user(user)
//	        .token(jwtToken)
//	        .tokenType(TokenType.BEARER)
//	        .expired(false)
//	        .revoked(false)
//	        .build();
//	    tokenRepository.save(token);
//	  }
  
}
