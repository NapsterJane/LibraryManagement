package com.library.management.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long publisher_id;
	private String publishername;
	
	@OneToOne(mappedBy = "publisher")
	private Books books;

	public long getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(long publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getPublishername() {
		return publishername;
	}

	public void setPublishername(String publishername) {
		this.publishername = publishername;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}
	
	
	
}
