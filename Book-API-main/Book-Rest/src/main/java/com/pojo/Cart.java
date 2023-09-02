package com.pojo;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Data
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany
	private List<Book> books;

	// getter and setter
	public Integer getId() {
		return id;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
}
