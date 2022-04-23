package org.audiostore.api.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@JsonIgnore
	private Long Id;
	
	private Long userId;
	
	
	private String name;
	

	private Long age;
	
	private String gender;
	
	private List<AddressTO> addressTO;
	
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public List<AddressTO> getAddressTO() {
		return addressTO;
	}

	public void setAddressTO(List<AddressTO> addressTO) {
		this.addressTO = addressTO;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<AddressTO> getAddress() {
		return addressTO;
	}

	public void setAddress(List<AddressTO> addressTO) {
		this.addressTO = addressTO;
	}

	@Override
	public String toString() {
		return "UserTO [Id=" + Id + ", userId=" + userId + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", addressTO=" + addressTO + "]";
	}

	
	
	
	

}
