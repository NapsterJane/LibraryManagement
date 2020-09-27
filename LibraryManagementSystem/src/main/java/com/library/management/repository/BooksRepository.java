package com.library.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.library.management.entity.Books;

@Repository
@EnableJpaRepositories
public interface BooksRepository extends JpaRepository<Books, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "delete from admin.books where book_id = ?1", nativeQuery = true)
	void deleteBook(long bookid);
}
