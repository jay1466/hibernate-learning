package com.telusko.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee1 
{
	 @Id
     private Integer eid;
     
     private String eName;
     
     @Transient  // this means this eCity named column is not created in table even though i will setting value in object there will not store in db
     private String ecity;
     
     private Integer eage;
	
	public Employee1()
	{
		System.out.println("Zero Param Constructor for Hibernate");
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getEcity() {
		return ecity;
	}

	public void setEcity(String ecity) {
		this.ecity = ecity;
	}

	public Integer getEage() {
		return eage;
	}

	public void setEage(Integer eage) {
		this.eage = eage;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", eName=" + eName + ", ecity=" + ecity + ", eage=" + eage + "]";
	}
	
	

	
	
	
}
