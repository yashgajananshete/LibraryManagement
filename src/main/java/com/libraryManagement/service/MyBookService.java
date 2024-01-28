package com.libraryManagement.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryManagement.entity.MyBook;
import com.libraryManagement.repository.MyBookRepository;

@Service
public class MyBookService {
	
	@Autowired
	MyBookRepository myBookRepo;
	
	public void savee(MyBook mb) {
		myBookRepo.save(mb);
	}
	
	public List<MyBook> getBookList(){
		return myBookRepo.findAll();		
	}
	
	public MyBook getBookById(int id) {
		
		MyBook mb = myBookRepo.getReferenceById(id);
		return mb;
		
	}
	
	public void deleteBookById(int id) {
		myBookRepo.deleteById(id);
	}
}
