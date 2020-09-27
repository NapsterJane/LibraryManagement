package com.library.management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.library.management.entity.Author;
import com.library.management.entity.Books;
import com.library.management.entity.Publisher;

@Service
@Transactional
public interface BooksService {

	Books saveBook(Books book, Author author, Publisher publisher);

	List<Books> viewAllBooks();

	//int updateBook(Books book, Author author, Publisher publisher);

	int updateAuthor(long author_id, String authorname);

	int updatePublisher(long publisher_id, String publishername);

	int deleteBook(Books books);

}
