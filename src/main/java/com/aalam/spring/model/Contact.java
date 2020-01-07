package com.aalam.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Contact {

	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	public Contact() {
	}
}
