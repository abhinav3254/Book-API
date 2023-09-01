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
	
	private Double total;
	
	private String shippingAddress;
	
	@OneToOne
	private Cart cart;
	
	@ManyToOne
	private User user;

	public Integer getId() {
		return id;
	}

	public Double getTotal() {
		return total;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public Cart getCart() {
		return cart;
	}

	public User getUser() {
		return user;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
