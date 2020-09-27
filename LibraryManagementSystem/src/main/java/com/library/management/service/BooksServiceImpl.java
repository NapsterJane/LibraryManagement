package com.library.management.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entity.Author;
import com.library.management.entity.Books;
import com.library.management.entity.Publisher;
import com.library.management.repository.AuthorRepository;
import com.library.management.repository.BooksRepository;
import com.library.management.repository.PublisherRepository;

@Service
@Transactional
public class BooksServiceImpl implements BooksService {
	
	@Autowired
	BooksRepository booksrepository;
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Override
	public Books saveBook(Books book, Author author, Publisher publisher) {
		author = authorRepository.save(author);
		publisher = publisherRepository.save(publisher);
		
		book.setAuthor(author);
		book.setPublisher(publisher);
		
		book = booksrepository.save(book);
		return book;
	}

	@Override
	public List<Books> viewAllBooks() {
		List<Books> books = new ArrayList<>();
		for(Books book : booksrepository.findAll()) {
			books.add(book);
		}
		return books;
	}

	/*
	 * @Override public int updateBook(Books book, Author author, Publisher
	 * publisher) {
	 * 
	 * int a = publisherRepository.updatePublisher(book.getBook_id(),
	 * publisher.getPublishername()); return 0; }
	 */

	@Override
	public int updateAuthor(long author_id, String authorname) {
		int result = authorRepository.updateAuthor(author_id, authorname);
		return result;
	}

	@Override
	public int updatePublisher(long publisher_id, String publishername) {
		int result = publisherRepository.updatePublisher(publisher_id, publishername);
		return result;
	}

	@Override
	public int deleteBook(Books books) {
		// TODO Auto-generated method stub
		booksrepository.deleteBook(books.getBook_id());
		return 1;
	}

}
