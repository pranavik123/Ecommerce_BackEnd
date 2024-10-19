package com.shoppingcartpoc.jwt;

public class JwtProperties {
	
	public static final String SECRET="PranaviInternDev123";
	public static final int EXPIRATION_TIME=86400000;
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING = "Authorization";
	private JwtProperties() {
		throw new IllegalStateException("JWT Properties class");
		}
	
}
