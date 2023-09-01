package com.restimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.rest.OrderRest;
import com.service.OrderService;

@RestController
public class OrderRestImpl implements OrderRest {
	
	@Autowired
	private OrderService orderService;

	@Override
	public ResponseEntity<String> orderBook(Map<String, String> map) {
		try {
			
			return orderService.orderBook(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("INTERNAL ISSUE",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
