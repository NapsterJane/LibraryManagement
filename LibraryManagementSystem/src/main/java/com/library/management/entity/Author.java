package com.library.management.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long author_id;
	
	private String authorname;
	
	@OneToOne(mappedBy = "author", fetch = FetchType.EAGER)
	private Books books;

	public long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(long author_id) {
		this.author_id = author_id;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}	
	
	
	
}
