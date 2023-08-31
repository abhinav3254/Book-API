package com.pojo;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Publishers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String country;
	
	@OneToMany(targetEntity = Book.class)
//	@JoinTable(name = "publisher_book",
//	joinColumns = {@JoinColumn(name = "p_id")},
//	inverseJoinColumns = {@JoinColumn(name = "b_id")})
	@JoinColumn(name="p_id") 
	@OrderColumn(name="type")
	private List<Book> book;
	
}
