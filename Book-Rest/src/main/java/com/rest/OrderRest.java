package com.rest;


import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.GetOrders;

@RequestMapping("/order")
public interface OrderRest {
	
	@PostMapping("/addbook")
	ResponseEntity<String> orderBook(@RequestBody(required = true)Map<String, String>map);
	
	@GetMapping("/orders")
	ResponseEntity<List<GetOrders>> getAllOrder();

}
