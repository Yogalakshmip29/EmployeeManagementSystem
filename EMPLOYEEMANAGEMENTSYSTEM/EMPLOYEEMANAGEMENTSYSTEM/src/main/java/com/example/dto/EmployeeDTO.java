


package com.example.dto;

import java.util.List;

import java.util.Objects;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class EmployeeDTO {

	
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
	
	private AddressDTO address;
	
	private DepartmentDTO dep;
	
    private List<ProjectDTO> project;
	public EmployeeDTO(Integer id, String name, String email, String phoneNumber, AddressDTO address, DepartmentDTO dep,
			List<ProjectDTO> project) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.dep = dep;
		this.project = project;
	}
	public EmployeeDTO() {
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
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public DepartmentDTO getDep() {
		return dep;
	}
	public void setDep(DepartmentDTO dep) {
		this.dep = dep;
	}
	public List<ProjectDTO> getProject() {
		return project;
	}
	public void setProject(List<ProjectDTO> project) {
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
		EmployeeDTO other = (EmployeeDTO) obj;
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
