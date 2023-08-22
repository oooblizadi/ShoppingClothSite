package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.pojos.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
@Table(name="addresses")
public class Address extends BaseEntity {
	
	@Column(length = 100)
	private String line1;
	@Column(length = 100)
	private String line2;
	private String street;
	private String town;
	private String city;
	private String country;
	private Integer pinCode;
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne(mappedBy="shippingAddress")
	private Shipping shipping;
}

