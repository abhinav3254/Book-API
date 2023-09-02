package com.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Cart cart;

	@ManyToOne
	private User user;
	
	// getters and setters
	public Integer getId() {
		return id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
