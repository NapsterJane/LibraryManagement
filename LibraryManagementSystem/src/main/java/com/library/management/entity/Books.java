package com.library.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private long book_id;
	private String bookname;
	
	@OneToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@OneToOne
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	private String category;
	private String coverimage;
	
	public long getBook_id() {
		return book_id;
	}
	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getCoverimage() {
		return coverimage;
	}
	public void setCoverimage(String coverimage) {
		this.coverimage = coverimage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
}
