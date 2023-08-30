package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pojo.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
	
	@Query(nativeQuery = true, value = "select * from book")
	List<Book> getAllBook();
	
	@Query(nativeQuery = true, value = "select * from book where book_author like %:book_author%")
	List<Book> getAllBookByAuthorName(String book_author);
	
	@Query(nativeQuery = true, value = "select * from book where book_category like %:book_category%")
	List<Book> getBybook_category(String book_category);
	
	@Query(nativeQuery = true, value = "select * from book where book_title like %:book_title%")
	List<Book> getBybook_title(String book_title);
	
}
