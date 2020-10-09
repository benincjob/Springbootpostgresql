package com.benin.sprigbootpostgresql.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customer_id;
	
	@Column(name="first_name")
	private String first_name;
	
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="account_number")
	private long account_number;
	
	@Column(name="product_id")
	private long product_id;
	
	@Column(name="ssn")
	private long ssn;


	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public customer(String first_name, String last_name, long account_number, long product_id, long ssn) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.account_number = account_number;
		this.product_id = product_id;
		this.ssn = ssn;
	}


	public long getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public long getAccount_number() {
		return account_number;
	}


	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}


	public long getProduct_id() {
		return product_id;
	}


	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}


	public long getSsn() {
		return ssn;
	}


	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	
	
	

}
