package com.example.jms.SpringBootJMSTest.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Messages_Stagging")
public class MainMessage  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3739590762754761991L;

	@Column(name="RequestType" ,length=1,nullable=false)
	private String requestType;
	
	@Id
	@Column(name="TRN" ,length=22,nullable=false)
	private String tRn;
	
	@Column(name="NAME" ,length=20,nullable=false)
	private String name;
	
	@Column(name="FormateType" ,length=21,nullable=false)
	private String formateType;
	
	@Column(name="Amount", length=19,nullable=false)
	private Double amount;
	
	@Column(name="Currency" , length=3,nullable=false)
	private String currency;
	
	@Column(name="Service", length=3,nullable=false)
	private String service;
	
	@Column(name="CountryCode", length=2,nullable=false)
	private String countryCode;
	
	@Column(name="RefferenceNumber", length=50,nullable=false)
	private String refferenceNumber;
	
	@Column(name="ExecutionDate" ,nullable=false)
	private Date executionDate;
	
	@Column(name="FxRate")
	private Double 	 fxRate;
 
    public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String gettRn() {
		return tRn;
	}

	public void settRn(String tRn) {
		this.tRn = tRn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormateType() {
		return formateType;
	}

	public void setFormateType(String formateType) {
		this.formateType = formateType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getRefferenceNumber() {
		return refferenceNumber;
	}

	public void setRefferenceNumber(String refferenceNumber) {
		this.refferenceNumber = refferenceNumber;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public Double getFxRate() {
		return fxRate;
	}

	public void setFxRate(Double fxRate) {
		this.fxRate = fxRate;
	}

	public MainMessage() {
    	
    }

	
}