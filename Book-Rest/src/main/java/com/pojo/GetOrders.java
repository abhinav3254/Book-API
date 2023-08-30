package com.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetOrders {

	  // Book attributes
    private Integer bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookCategory;
    private Long bookISBN;
    private String bookPublisher;
    private String bookLanguage;
    private Integer bookPageCount;
    
    private String bookShortDesc;
    
    private String bookLongDesc;
    
    private String bookLongThumbnailUrl;
    private String bookPublishStatus;
    private Double bookPrice;

    // Order attributes
    private Integer orderId;
    private Integer user_Id;
    private Double orderTotal;
    private String paymentMethod;
    private String shippingAddress;
    private String billingAddress;
    private String orderStatus;
    private String shippingMethod;
    private String paymentStatus;
    private Double discountAmount;
    private Double taxAmount;
    private String notes;

    // User attributes
    private Integer userId;
    private String username;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String status;
    private String role;


}
