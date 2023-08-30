package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pojo.GetOrders;
import com.pojo.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
	
//	String queryJoin = "SELECT orders.*, book.*, user.*\n"
//			+ "FROM orders\n"
//			+ "JOIN book ON book.id = orders.order_id\n"
//			+ "JOIN user ON user.id = orders.order_id;";
	
	@Query(nativeQuery = true,value = "SELECT orders.*, book.*, user.*\n"
			+ "FROM orders\n"
			+ "JOIN book ON book.id = orders.order_id\n"
			+ "JOIN user ON :id = orders.order_id;")
	List<GetOrders> getOrders(String id);

}
