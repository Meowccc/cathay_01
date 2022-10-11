package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author meow
 */
@NoRepositoryBean
public interface BaseRepo<T, ID> extends JpaRepository<T, ID> {
}
