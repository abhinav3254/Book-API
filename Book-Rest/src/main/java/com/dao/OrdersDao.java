package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pojo.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer> {
	
	@Query(nativeQuery = true,value = "select orders.*,cart_books.*,book.title,user.name from cart_books\n"
			+ "join orders on orders.cart_id = cart_books.cart_id\n"
			+ "join book on book.id = cart_books.books_id\n"
			+ "join user on user.id = orders.user_id;")
	public List<Orders> getAllOrders();

}
