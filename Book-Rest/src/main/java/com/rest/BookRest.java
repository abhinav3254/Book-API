package com.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pojo.Book;


@RequestMapping("/book")
public interface BookRest {
	
	@PostMapping("/add")
	ResponseEntity<String> addBook(@RequestBody(required = true)Map<String, String>requestmap);
	
	
	@GetMapping("/all")
	ResponseEntity<List<Book>> getAllBooks();
	
	@PostMapping("/find")
	ResponseEntity<List<Book>> getBookByAuthorName(@RequestBody(required = true)Map<String, String> map);

}
