package com.ChatClone.B.Login.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User {
	@Id
	private String username;
	
	@Column
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Role role;
	
	@Builder
	public User(String username, String name, Role role) {
		this.name=name;
		this.username=username;
		this.role=role;
	}
	
	public User update(String name) {
		this.name=name;
		
		return this;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}
}
