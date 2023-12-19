package com.authorize.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String city;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JsonIgnore
	private List<Role> role;

	public User(String name, String password, String city, List<Role> role) {
		super();
		this.name = name;
		this.password = password;
		this.city = city;
		this.role = role;
	}

//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		for (Role userRole : role) {
//			authorities.add(new SimpleGrantedAuthority(userRole.getName()));
//		}
//		return authorities;
//	}
	
	public User(User user) {
		this.city = user.city;
		this.name=user.name;
		this.password=user.password;
		this.role = user.getRole();
	}

//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//	@Override
//	public String getUsername() {
//		return name;
//	}

	
}
