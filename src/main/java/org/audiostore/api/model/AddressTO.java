package org.audiostore.api.model;

import java.io.Serializable;

public class AddressTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String flatNo;
	private int floor;
	private String street;
	private String landmark;
	private String dist;
	private String postOffice;
	private String state;
	private int pinCode;
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		dist = dist;
	}
	public String getPostOffice() {
		return postOffice;
	}
	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "AddressTO [flatNo=" + flatNo + ", floor=" + floor + ", street=" + street + ", landmark=" + landmark
				+ ", Dist=" + dist + ", postOffice=" + postOffice + ", state=" + state + ", pinCode=" + pinCode + "]";
	}
	
	

}
