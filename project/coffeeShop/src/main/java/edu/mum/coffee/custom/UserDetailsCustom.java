package edu.mum.coffee.custom;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Role;
import edu.mum.coffee.domain.User;

public class UserDetailsCustom implements UserDetails {
	private static final long serialVersionUID = -1360188483928178893L;
	private User user;
	private Person person;

	public UserDetailsCustom(User user) {
		this.user = user;
	}

	public UserDetailsCustom(User user, Person person) {
		this.user = user;
		this.person = person;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		//user.getRoles().stream().forEach(authorities::add);
		//return authorities;
		//authorities.addAll((Collection<? extends GrantedAuthority>)user.getRoles());
		for(Role role: this.user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
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
		return user.isEnabled();
	}

	public User getUser() {
		return user;
	}

	public Person getPerson() {
		return person;
	}
	
	public Long getId() {
		return this.user.getId();
	}
}
