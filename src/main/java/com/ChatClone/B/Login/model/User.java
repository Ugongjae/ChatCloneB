package com.ChatClone.B.Login.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String picture;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Role role;
	
	@Builder
	public User(String name, String email,String picture, Role role) {
		this.name=name;
		this.picture=picture;
		this.email=email;
		this.role=role;
	}
	
	public User update(String name,String picture) {
		this.name=name;
		this.picture=picture;
		
		return this;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}
}
