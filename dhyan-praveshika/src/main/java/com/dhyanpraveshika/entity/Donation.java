package com.dhyanpraveshika.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dps_donation")
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "donar")
	private String donar;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "created_date")
	private Date created_date;
	
	@Column(name = "transaction_id")
	private String transaction_id;
	
	@Column(name = "amount")
	private String amount;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDonar() {
		return donar;
	}

	public void setDonar(String donar) {
		this.donar = donar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", donar=" + donar + ", email=" + email + ", created_date=" + created_date
				+ ", transaction_id=" + transaction_id + ", amount=" + amount + "]";
	}

	

}
