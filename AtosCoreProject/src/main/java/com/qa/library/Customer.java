package com.qa.library;

public class Customer {

	private int id;
	private String fName;
	private String sName;
	private String address;
	private String postcode;
	
	
	public Customer() {
		super();
	}
	
	public Customer(int id, String fName, String sName, String address, String postcode) {
		super();
		this.id = id;
		this.fName = fName;
		this.sName = sName;
		this.address = address;
		this.postcode = postcode;
	}
	
	public Customer(String fName, String sName, String address, String postcode) {
		super();
		this.fName = fName;
		this.sName = sName;
		this.address = address;
		this.postcode = postcode;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", fName=" + fName + ", sName=" + sName + ", address=" + address
				+ ", postcode=" + postcode + "]";
	}
	
}
