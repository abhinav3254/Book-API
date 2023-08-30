package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.pojo.Book;

public interface BookService {
	
	ResponseEntity<String> addBook(Map<String, String>map);
	
	ResponseEntity<List<Book>> getAllBook();
	
	ResponseEntity<List<Book>> getBookByAuthorName(Map<String, String>map);
	
}
