package com.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Double total;
	
	private String shippingAddress;
	
	@OneToOne(targetEntity = Cart.class)
	private Cart cart;
	
	@OneToOne(targetEntity = User.class)
	private User user;

}
