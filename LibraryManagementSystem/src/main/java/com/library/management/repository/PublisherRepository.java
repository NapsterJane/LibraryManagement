package com.library.management.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.library.management.entity.Publisher;

@Repository
@EnableJpaRepositories
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
	
	//Custom Query
	@Transactional
	@Modifying
	@Query(value = "UPDATE admin.publisher set publishername = ?2 where publisher_id = ?1", nativeQuery = true)
	int updatePublisher(long publisher_id, String publishername);

}
