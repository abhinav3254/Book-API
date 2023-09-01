package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pojo.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
	
	@Query(nativeQuery = true,value = "select book.*,PUBLISHERS.id,author.id from book\r\n"
			+ "join PUBLISHERS on PUBLISHERS.id = book.publishers_id\r\n"
			+ "join author on author.id = book.author_id")
	public List<Book> getAllBooks();
	
}
