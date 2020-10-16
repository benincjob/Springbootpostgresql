package com.benin.sprigbootpostgresql.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_by_customers")
public class product_by_customers {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long product_by_customer_id;

	@Column(name="product_id")
	private long product_id;
	
	@Column(name="customer_id")
	private long customer_id;

	public product_by_customers() {
		super();

	}

	public product_by_customers(long product_id, long customer_id) {
		super();
		this.product_id = product_id;
		this.customer_id = customer_id;
	}

	public long getProduct_by_customer_id() {
		return product_by_customer_id;
	}

	public void setProduct_by_customer_id(long product_by_customer_id) {
		this.product_by_customer_id = product_by_customer_id;
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	
	

}
