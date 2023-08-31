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
	
}
