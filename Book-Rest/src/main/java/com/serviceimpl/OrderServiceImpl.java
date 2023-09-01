package com.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.constants.Constants;
import com.dao.CartDao;
import com.dao.OrdersDao;
import com.dao.UserDao;
import com.jwt.JwtUtils;
import com.pojo.Cart;
import com.pojo.Orders;
import com.pojo.User;
import com.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public ResponseEntity<String> placeOrder(Map<String, String> map) {
		try {
			
			System.out.println(map.get("cartId"));
			Orders orders = orderConfig(map);
			ordersDao.save(orders);
			return new ResponseEntity<String>(Constants.designMessage("Order Placed"),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(Constants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private Orders orderConfig(Map<String, String>map) {
		try {
			Orders orders = new Orders();
			
			Cart cart = cartDao.getById(Integer.parseInt(map.get("cartId")));
			
			orders.setCart(cart);
			
			Authentication authentication = SecurityContextHolder. getContext(). getAuthentication();
			String token = authentication.getName();
			
			String username = jwtUtils.extractUsername(token);
			
			User user = userDao.getUserByUserName(username);
			
			orders.setUser(user);
			
			return orders;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException(Constants.designMessage("ALL FIELDS ARE MANDATORY!!"));
	}

	@Override
	public ResponseEntity<List<Orders>> getAllOrders() {
		try {
			List<Orders> listOrders = ordersDao.getAllOrders();
			return new ResponseEntity<List<Orders>>(listOrders,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Orders>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
