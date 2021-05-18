package com.cg.vegetable.module;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	private int id;
	private int flatNo;
	private String buildingName;
	private String area;
	private String location;
	private String state;
	private String pincode;
	
	//@OneToOne(mappedBy = "address")
	//private Customer customer;
		
	public Address() {}

	public Address(int id, int flatNo, String buildingName, String area, String location, String state, String pincode) {
		super();
		this.id = id;
		this.flatNo = flatNo;
		this.buildingName = buildingName;
		this.area = area;
		this.location = location;
		this.state = state;
		this.pincode = pincode;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	/*@JsonManagedReference
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
*/
	@Override
	public String toString() {
		return "Address [id=" + id + ", flatNo=" + flatNo + ", buildingName=" + buildingName + ", area=" + area
				+ ", location=" + location + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
}
