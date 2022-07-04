package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JwtRequest;
import com.example.demo.entity.JwtResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.util.JwtUtil;

@Service
public class JwtService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public JwtResponse CreateJwtToken(JwtRequest jwtRequest) throws Exception
	{
		String email = jwtRequest.getEmail();
		String password = jwtRequest.getPassword();
		authenticate(email, password);
		
		UserDetails userDetails = loadUserByUsername(email);
		String newGeneratedToken =jwtUtil.generateToken(userDetails);
		
		User user = userRepo.findById(email).get();
		return new JwtResponse(user,newGeneratedToken);
		
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepo.findById(email).get();
		if(user != null)
		{
			return new org.springframework.security.core.userdetails.User
					(user.getEmail(), user.getPassword(), getAuthority(user));
		}
		else {
			throw new UsernameNotFoundException("User not found with email" + email);
		}
		
		
	}
	
	private  Set getAuthority(User user) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRole().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		});
		return authorities;
	}
	
	public void authenticate(String email, String password) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		}
		catch(DisabledException e) {
			System.out.println("user is disabled");
		}
		catch(BadCredentialsException e) {
			System.out.println("Bad credential from user");
		}
	}

}
