package com.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.BookDao;
import com.jwt.JwtFilter;
import com.pojo.Book;
import com.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Autowired
	private BookDao bookDao;

	@Override
	public ResponseEntity<String> addBook(Map<String, String> map) {
		try {
			if (jwtFilter.isAdmin()) {
				bookDao.save(bookConfig(map));
				return new ResponseEntity<String>("ADDED",HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("UNAUTHORIZED ACCESS",HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("INTERNAL ISSUE",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private Book bookConfig(Map<String, String> map) {
		try {
			Book book = new Book();
			
			book.setBookAuthor(map.get("author"));
			book.setBookCategory(map.get("category"));
			book.setBookISBN(Long.parseLong(map.get("isbn")));
			book.setBookLanguage(map.get("language"));
			book.setBookLongDesc(map.get("longDesc"));
			book.setBookLongThumbnailUrl(map.get("thumbnail"));
			book.setBookPageCount(Integer.parseInt(map.get("pageCount")));
			book.setBookPublisher(map.get("publisher"));
			book.setBookPublishStatus(map.get("publishStatus"));
			book.setBookShortDesc(map.get("shortDesc"));
			book.setBookTitle(map.get("title"));
			book.setPrice(Double.parseDouble(map.get("price")));
			
			return book;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseEntity<List<Book>> getAllBook() {
		
		try {
			System.out.println("Inside getAll Books");
			List<Book> listBook = bookDao.getAllBook();
			if (listBook.isEmpty()) {
				System.out.println("Book is Empty");
				return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Book>>(listBook,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<Book>> getBookByAuthorName(Map<String, String> map) {
		try {
			if (map.containsKey("author")) {
				System.out.println("AuthorName Called");
				List<Book> list =  bookDao.getAllBookByAuthorName(map.get("author"));
				return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
			} else if (map.containsKey("title")) {
				System.out.println("title Called");
				List<Book> list =  bookDao.getBybook_title(map.get("title"));
				return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
			} else if (map.containsKey("category")) {
				System.out.println("Category Called");
				List<Book> list =  bookDao.getBybook_category(map.get("category"));
				return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Book>>(HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
