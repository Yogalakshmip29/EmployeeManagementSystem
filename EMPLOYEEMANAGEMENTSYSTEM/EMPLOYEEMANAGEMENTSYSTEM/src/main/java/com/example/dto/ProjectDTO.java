package com.example.dto;

import java.util.List;

import java.util.Objects;

import org.springframework.scheduling.config.Task;




public class ProjectDTO {

private Integer id;
private String name;
private String description;


private List<EmployeeDTO> emp;


private List<Task> tk;

public ProjectDTO(Integer id, String name, String description, List<EmployeeDTO> emp, List<Task> tk) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.emp = emp;
	this.tk = tk;
}

public ProjectDTO() {
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

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public List<EmployeeDTO> getEmp() {
	return emp;
}

public void setEmp(List<EmployeeDTO> emp) {
	this.emp = emp;
}

public List<Task> getTk() {
	return tk;
}

public void setTk(List<Task> tk) {
	this.tk = tk;
}

@Override
public String toString() {
	return "Project [id=" + id + ", name=" + name + ", description=" + description + ", emp=" + emp + ", tk=" + tk
			+ "]";
}

@Override
public int hashCode() {
	return Objects.hash(description, emp, id, name, tk);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ProjectDTO other = (ProjectDTO) obj;
	return Objects.equals(description, other.description) && Objects.equals(emp, other.emp)
			&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(tk, other.tk);
}





}
