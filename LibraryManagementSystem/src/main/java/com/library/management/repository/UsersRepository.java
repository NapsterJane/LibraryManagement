package com.library.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.library.management.entity.Users;

@Repository
@EnableJpaRepositories
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
