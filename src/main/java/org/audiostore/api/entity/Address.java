package org.audiostore.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int Id;
	@Column (name="flatno")
	private String flatNo;
	@Column(name="floor")
	private int floor;
	@Column(name="street")
	private String street;
	@Column(name="landmark")
	private String landmark;
	@Column(name="dist")
	private String dist;
	@Column(name="postoffice")
	private String postOffice;
	@Column(name="state")
	private String state;
	@Column(name="pincode")
	private int pinCode;
	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	private User user;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dist == null) ? 0 : dist.hashCode());
		result = prime * result + Id;
		result = prime * result + ((flatNo == null) ? 0 : flatNo.hashCode());
		result = prime * result + floor;
		result = prime * result + ((landmark == null) ? 0 : landmark.hashCode());
		result = prime * result + pinCode;
		result = prime * result + ((postOffice == null) ? 0 : postOffice.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (dist == null) {
			if (other.dist != null)
				return false;
		} else if (!dist.equals(other.dist))
			return false;
		if (Id != other.Id)
			return false;
		if (flatNo == null) {
			if (other.flatNo != null)
				return false;
		} else if (!flatNo.equals(other.flatNo))
			return false;
		if (floor != other.floor)
			return false;
		if (landmark == null) {
			if (other.landmark != null)
				return false;
		} else if (!landmark.equals(other.landmark))
			return false;
		if (pinCode != other.pinCode)
			return false;
		if (postOffice == null) {
			if (other.postOffice != null)
				return false;
		} else if (!postOffice.equals(other.postOffice))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [Id=" + Id + ", flatNo=" + flatNo + ", floor=" + floor + ", street=" + street + ", landmark="
				+ landmark + ", Dist=" + dist + ", postOffice=" + postOffice + ", state=" + state + ", pinCode="
				+ pinCode + "]";
	}
	
	

}
