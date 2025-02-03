package com.example.dto;

import java.util.List;

import java.util.Objects;

import javax.persistence.Column;




public class DepartmentDTO {

	
	private Integer id;
	@Column(nullable=false)
	private String name;

	private List<EmployeeDTO> employee;
	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentDTO(Integer id, String name, List<EmployeeDTO> employee) {
		super();
		this.id = id;
		this.name = name;
		this.employee = employee;
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
	public List<EmployeeDTO> getEmployee() {
		return employee;
	}
	public void setEmployee(List<EmployeeDTO> employee) {
		this.employee = employee;
	}
	@Override
	public int hashCode() {
		return Objects.hash(employee, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentDTO other = (DepartmentDTO) obj;
		return Objects.equals(employee, other.employee) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employee=" + employee + "]";
	}
	
	
	
	
	
	
	
	
}
