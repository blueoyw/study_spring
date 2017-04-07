package com.board.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//이것은 Hibernate 가 자동적으로 table로 변환하는 Entity class 이다.
@Entity	// This tells Hibernate to make a table out of this class.
public class User {
	@Id		//primary key
	@GeneratedValue		//@id와 같이 사용하여 key 값을 generate 함.
	private Long id;
	
	private String name;
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
