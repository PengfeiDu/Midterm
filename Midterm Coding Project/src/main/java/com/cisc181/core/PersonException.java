package com.cisc181.core;

public class PersonException extends Exception{
	
	private Person person;

	public PersonException(Person person, String Message) {
		super();
		this.person = person;
		System.out.println(Message);
	}
	

}
