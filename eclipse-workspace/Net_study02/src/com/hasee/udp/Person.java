package com.hasee.udp;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
}
