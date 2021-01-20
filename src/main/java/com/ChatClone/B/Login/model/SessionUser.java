package com.ChatClone.B.Login.model;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable{
	private String username;
	private String name;
	
	public SessionUser(User user) {
		this.username=user.getUsername();
		this.name=user.getName();
	}
}
