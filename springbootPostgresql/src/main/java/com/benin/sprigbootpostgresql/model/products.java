package com.benin.sprigbootpostgresql.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long product_id;
	
	
	@Column(name="product_description")
	private String product_description;
	
	@Column(name="interest_rate")
	private long interest_rate;


	public products() {
		super();
	}


	public products(String product_description, long interest_rate) {
		super();
		this.product_description = product_description;
		this.interest_rate = interest_rate;
	}


	public long getProduct_id() {
		return product_id;
	}


	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}


	public String getProduct_description() {
		return product_description;
	}


	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}


	public long getInterest_rate() {
		return interest_rate;
	}


	public void setInterest_rate(long interest_rate) {
		this.interest_rate = interest_rate;
	}
	

}
