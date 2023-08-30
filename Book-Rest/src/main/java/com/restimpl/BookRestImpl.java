package com.restimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pojo.Book;
import com.rest.BookRest;
import com.service.BookService;

@RestController
public class BookRestImpl implements BookRest {
	
	@Autowired
	private BookService bookService;
	
	

	@Override
	public ResponseEntity<String> addBook(Map<String, String> requestmap) {
		try {
			return bookService.addBook(requestmap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("SOMETHING WENT WRON",HttpStatus.INTERNAL_SERVER_ERROR);
	}



	@Override
	public ResponseEntity<List<Book>> getAllBooks() {
		try {
			return bookService.getAllBook();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}



	@Override
	public ResponseEntity<List<Book>> getBookByAuthorName(Map<String, String> map) {
		try {
			return bookService.getBookByAuthorName(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
