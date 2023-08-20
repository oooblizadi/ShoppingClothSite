package com.app.dtos;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDto {

    @NotNull(message = "customerId is mandatory")
    private Long customerId;

    @NotNull(message = "orderDate is mandatory")
    private Date orderDate;

    @NotNull(message = "totalAmount is mandatory")
    @Positive(message = "totalAmount must be a positive number")
    private Double totalAmount;

    @NotNull(message = "paymentMethod is mandatory")
    private String paymentMethod;

    @NotNull(message = "paymentStatus is mandatory")
    private String paymentStatus;

    @NotBlank(message = "shippingAddress is mandatory")
    private String shippingAddress;
    
    private List<ProductDto> products;
	

}
