package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface OrderService {
	
	ResponseEntity<String> orderBook(Map<String, String> map);
	
}
