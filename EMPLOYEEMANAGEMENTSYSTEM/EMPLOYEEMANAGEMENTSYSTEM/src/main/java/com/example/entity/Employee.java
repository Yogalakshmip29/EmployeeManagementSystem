package com.example.entity;

import java.util.List;


import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;



@Entity
@Table(uniqueConstraints=   
{
		@UniqueConstraint(columnNames="email"),
		@UniqueConstraint(columnNames="phone_number")// means database itself column must have unique values which we mentioned
})
@JacksonXmlRootElement(localName="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	@NotNull
	@Size(min=1,max=100,message="name should be between 1 and 100")
	@Column(nullable=false)
	private String name;
	@Pattern(regexp="[A-Z][a-z]+\\d{1,3}@gmail.com",message="invalid email format")
	@Column(nullable=false,unique=true)
	private String email;
	@Column(nullable=false,unique=true)
	@Pattern(regexp="[+]?\\d{10,15}",message="phone number is invalid")
	private String phoneNumber;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="a_id",unique=true)
	private Address address;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="e_id")
	private Department dep;
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="PE",  
	joinColumns= {
		    @JoinColumn(name="employee_id",referencedColumnName="e_id")
		},
	inverseJoinColumns= {
			@JoinColumn(name="project_id",referencedColumnName="p_id")
	}
)
    private List<Project> project;
	public Employee(Integer id, String name, String email, String phoneNumber, Address address, Department dep,
			List<Project> project) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dep = dep;
		this.project = project;
	}
	public Employee() {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Department getDep() {
		return dep;
	}
	public void setDep(Department dep) {
		this.dep = dep;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, dep, email, id, name, phoneNumber, project);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(dep, other.dep)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(project, other.project);
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", dep=" + dep + ", project=" + project + "]";
	}
	
	
	
}
