package com.serviceimpl;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.BookDao;
import com.dao.UserDao;
import com.jwt.JwtUtils;

import com.pojo.Orders;
import com.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private BookDao bookDao;

	@Override
	public ResponseEntity<String> orderBook(Map<String, String> map) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("INTERNAL ISSUE",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private Orders orderConfig(Map<String, String> map) {
	    try {
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return null;
	}

}
