package com.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libraryManagement.entity.MyBook;

@Repository
public interface MyBookRepository extends JpaRepository<MyBook, Integer> {

}
