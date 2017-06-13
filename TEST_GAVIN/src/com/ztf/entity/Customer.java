package com.ztf.entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

	String name;
	int age;
	int id;
	
	String address;
	ArrayList<String> mobileNo;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddress() {
	    return address;
	}

	@XmlElement
	public void setAddress(String address) {
	    this.address = address;
	}

	public ArrayList<String> getMobileNo() {
	    return mobileNo;
	}

	@XmlElement
	public void setMobileNo(ArrayList<String> mobileNo) {
	    this.mobileNo = mobileNo;
	}


}
