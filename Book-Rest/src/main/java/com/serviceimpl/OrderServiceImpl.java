package com.serviceimpl;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dao.BookDao;
import com.dao.OrderDao;
import com.dao.UserDao;
import com.jwt.JwtUtils;
import com.pojo.Book;
import com.pojo.GetOrders;
import com.pojo.Order;
import com.pojo.User;
import com.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private BookDao bookDao;

	@Override
	public ResponseEntity<String> orderBook(Map<String, String> map) {
		try {
			Order order = orderConfig(map);
			if (order!= null) {
			
			orderDao.save(order);
			
			return new ResponseEntity<String>("saved",HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("SOME FIELDS ARE EMPTY OR WRONG",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("INTERNAL ISSUE",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private Order orderConfig(Map<String, String> map) {
	    try {
	    	Order order = new Order();
	    	
	    	// finding book by id
	    	
	    	Optional<Book> bookList = bookDao.findById(Integer.parseInt(map.get("bookId")));
	    	Book book = bookList.get();

		    order.setBookId(Integer.parseInt(map.get("bookId")));
		    order.setBillingAddress(map.get("billingAddress"));
		    order.setShippingAddress(map.get("shippingAddress"));
		    order.setNotes(map.get("notes"));
		    
		    order.setPaymentMethod("Credit Card");
		    order.setOrderStatus("Placed");
		    order.setShippingMethod("Third-Party Shipping Services");
		    order.setPaymentStatus("paid");
		    
		    // setting all these methods
		    
		    Double discount = 0.10 * book.getPrice();
		    Double tax = 0.20 * book.getPrice();
		    Double totalPrice = (book.getPrice()+tax)-discount;
		    
		    order.setDiscountAmount(discount);
		    order.setTaxAmount(tax);
		    order.setOrderTotal(totalPrice);
		    
		    Authentication auth = SecurityContextHolder. getContext(). getAuthentication();
		   
		    String token = auth.getPrincipal()+"";
		    
		    String username = jwtUtils.extractUsername(token);
		    
		    User user = userDao.getUserByUserName(username);
		    
		    order.setUserId(user.getId());
		    
		    
//		    order.setUser(user);
		    
//		    System.out.println(user.toString());
		    
		    return order;
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return null;
	}

	@Override
	public ResponseEntity<List<GetOrders>> getAllOrder() {
		try {
			Authentication auth = SecurityContextHolder. getContext(). getAuthentication();
			   
		    String token = auth.getPrincipal()+"";
		    
		    String username = jwtUtils.extractUsername(token);
		    
		    User user = userDao.getUserByUserName(username);
		    
			List<GetOrders> list = orderDao.getOrders(user.getId()+"");
			return new ResponseEntity<List<GetOrders>>(list,HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
