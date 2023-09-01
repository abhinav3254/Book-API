package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String bookTitle;
    private String bookAuthor;
    private String bookCategory;
    private Long bookISBN;
    private String bookPublisher;
    private String bookLanguage;
    private Integer bookPageCount;
    @Column(length = 1000)
    private String bookShortDesc;
    @Column(length = 2000)
    private String bookLongDesc;
    @Column(length = 2000)
    private String bookLongThumbnailUrl;
    private String bookPublishStatus;
    private Double price;
	public Integer getId() {
		return id;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public Long getBookISBN() {
		return bookISBN;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public String getBookLanguage() {
		return bookLanguage;
	}
	public Integer getBookPageCount() {
		return bookPageCount;
	}
	public String getBookShortDesc() {
		return bookShortDesc;
	}
	public String getBookLongDesc() {
		return bookLongDesc;
	}
	public String getBookLongThumbnailUrl() {
		return bookLongThumbnailUrl;
	}
	public String getBookPublishStatus() {
		return bookPublishStatus;
	}
	public Double getPrice() {
		return price;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	public void setBookISBN(Long bookISBN) {
		this.bookISBN = bookISBN;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}
	public void setBookPageCount(Integer bookPageCount) {
		this.bookPageCount = bookPageCount;
	}
	public void setBookShortDesc(String bookShortDesc) {
		this.bookShortDesc = bookShortDesc;
	}
	public void setBookLongDesc(String bookLongDesc) {
		this.bookLongDesc = bookLongDesc;
	}
	public void setBookLongThumbnailUrl(String bookLongThumbnailUrl) {
		this.bookLongThumbnailUrl = bookLongThumbnailUrl;
	}
	public void setBookPublishStatus(String bookPublishStatus) {
		this.bookPublishStatus = bookPublishStatus;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
