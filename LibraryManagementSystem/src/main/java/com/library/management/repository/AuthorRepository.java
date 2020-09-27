package com.library.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.management.entity.Author;

@Repository
@EnableJpaRepositories
public interface AuthorRepository extends CrudRepository<Author, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin.authors set authorname = ?2 where author_id = ?1", nativeQuery = true)
	int updateAuthor(long author_id, String authorname);
}
