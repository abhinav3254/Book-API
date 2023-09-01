package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pojo.Cart;

public interface CartDao extends JpaRepository<Cart, Integer> {
	
	@Query(nativeQuery = true,value = "select cart.*,book.* from cart_books\r\n"
			+ "join cart on cart.id = cart_books.cart_id\r\n"
			+ "join book on book.id = cart_books.books_id;")
	public List<Cart> getAllItemsInCart();
	
}
