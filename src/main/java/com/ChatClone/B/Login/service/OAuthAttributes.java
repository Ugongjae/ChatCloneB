package com.ChatClone.B.Login.service;

import java.util.Map;


import com.ChatClone.B.Login.model.Role;
import com.ChatClone.B.Login.model.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private Map<String,Object> attributes;
	private String usernameAttributeKey;
	private String username;
	private String name;
	
	@Builder
	public OAuthAttributes(Map<String,Object> attributes,String usernameAttributeKey,String username, String name) {
		this.attributes=attributes;
		this.usernameAttributeKey=usernameAttributeKey;
		this.username=username;
		this.name=name;
	}
	
	public static OAuthAttributes of(String registrationId,String userUsernameAttributeUsername,Map<String,Object> attributes) {
		return ofCustom(userUsernameAttributeUsername,attributes);
	}
	
	public static OAuthAttributes ofCustom(String userUsernameAttributeUsername,Map<String,Object> attributes) {
		return OAuthAttributes.builder()
				.username((String)attributes.get("username"))
				.name((String)attributes.get("name"))
				.attributes(attributes)
				.usernameAttributeKey(userUsernameAttributeUsername)
				.build();
	}
	
	public User toEntity() {
		return User.builder()
				.username(this.username)
				.name(this.name)
				.role(Role.USER)
				.build();
	}

}
