package com.library.management.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private long user_id;
	private String fullname;
	private String username;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_books", joinColumns = { @JoinColumn(referencedColumnName = "user_id")},
	inverseJoinColumns = {@JoinColumn(referencedColumnName = "book_id") })
	private Set<Books> bookallowed = new HashSet<Books>(0);

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Books> getBookallowed() {
		return bookallowed;
	}

	public void setBookallowed(Set<Books> bookallowed) {
		this.bookallowed = bookallowed;
	}
	
	
}
