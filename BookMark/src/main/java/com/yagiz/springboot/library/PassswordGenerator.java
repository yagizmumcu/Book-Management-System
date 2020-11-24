package com.yagiz.springboot.library;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassswordGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "asd123";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println(encodedPassword);

	}

}
