package com.ChatClone.B.Login.service;

import java.util.Map;


import com.ChatClone.B.Login.model.Role;
import com.ChatClone.B.Login.model.User;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private Map<String,Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String email;
	private String picture;
	
	@Builder
	public OAuthAttributes(Map<String,Object> attributes,String nameAttributeKey,String name, String email,String picture) {
		this.attributes=attributes;
		this.nameAttributeKey=nameAttributeKey;
		this.email=email;
		this.picture=picture;
		this.name=name;
	}
	
	public static OAuthAttributes of(String registrationId,String userNameAttrubiteName,Map<String,Object> attributes) {
		return ofCustom(userNameAttrubiteName,attributes);
	}
	
	public static OAuthAttributes ofCustom(String userNameAttributeName,Map<String,Object> attributes) {
		return OAuthAttributes.builder()
				.email((String)attributes.get("email"))
				.name((String)attributes.get("name"))
				.picture((String)attributes.get("picture"))
				.nameAttributeKey(userNameAttributeName)
				.build();
	}
	
	public User toEntity() {
		return User.builder()
				.name(this.name)
				.email(this.email)
				.picture(this.picture)
				.role(Role.GUEST)
				.build();
	}

}
