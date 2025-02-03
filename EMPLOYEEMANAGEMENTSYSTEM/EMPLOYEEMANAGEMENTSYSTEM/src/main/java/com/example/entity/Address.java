package com.example.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;




@Entity
public class Address {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
@Column(nullable=false)
private String name;
private String city;
@Column(nullable=false)
private String postalCode;

@OneToOne(mappedBy="address",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
private Employee employee;

public Address(Integer id, String name, String city, String postalCode, Employee employee) {
	super();
	this.id = id;
	this.name = name;
	this.city = city;
	this.postalCode = postalCode;
	this.employee = employee;
}

public Address() {
	super();
	// TODO Auto-generated constructor stub
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getPostalCode() {
	return postalCode;
}

public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

@Override
public int hashCode() {
	return Objects.hash(city, employee, id, name, postalCode);
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
	return Objects.equals(city, other.city) && Objects.equals(employee, other.employee) && Objects.equals(id, other.id)
			&& Objects.equals(name, other.name) && Objects.equals(postalCode, other.postalCode);
}

@Override
public String toString() {
	return "Address [id=" + id + ", name=" + name + ", city=" + city + ", postalCode=" + postalCode + ", employee="
			+ employee + "]";
}


}