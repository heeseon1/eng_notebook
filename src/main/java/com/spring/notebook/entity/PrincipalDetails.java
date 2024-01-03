package com.spring.notebook.entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class PrincipalDetails implements UserDetails, OAuth2User {
	
	private Users users;
	
	public PrincipalDetails(Users users) {
		this.users = users;
	}
	
	public String getUserUrl() {
		return users.getUserUrl();
	}
	
	public Long getUserId() {
		return users.getUserId();
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("user"));
	}

	@Override
	public String getPassword() {
		return users.getPassword();
	}

	@Override
	public String getUsername() {
		return users.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	private Map<String, Object> attributes;
	
	public PrincipalDetails(Users users, Map<String, Object> attributes) {
		this.users = users;
		this.attributes = attributes;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public String getName() {
		return null;
	}

}
