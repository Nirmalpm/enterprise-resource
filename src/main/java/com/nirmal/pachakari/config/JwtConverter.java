package com.nirmal.pachakari.config;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import com.nirmal.pachakari.model.AccessTokenMapper;



@Component
public class JwtConverter extends DefaultAccessTokenConverter implements JwtAccessTokenConverterConfigurer{

	

	@Override
	public void configure(JwtAccessTokenConverter converter) {
		converter.setAccessTokenConverter(this);
		
	}

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		// TODO Auto-generated method stub
		OAuth2Authentication auth  = super.extractAuthentication(map);
		AccessTokenMapper details = new AccessTokenMapper();
		if(map.get("id") != null) {
			details.setId((String) map.get("id"));
		}
		if(map.get("UserName") != null) {
			details.setUserName((String) map.get("UserName"));
		}
		if(map.get("name") != null) {
			details.setName((String) map.get("name"));
		}
		auth.setDetails(details);
		return auth;
	}

	@Override
	public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map) {
		// TODO Auto-generated method stub
		return super.extractAccessToken(value, map);
	}

}
