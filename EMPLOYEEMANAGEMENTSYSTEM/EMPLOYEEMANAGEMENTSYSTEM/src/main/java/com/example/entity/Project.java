package com.example.entity;

import java.util.List;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.scheduling.config.Task;



@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String name;
private String description;

@ManyToMany(cascade=CascadeType.ALL)
@JoinTable(name="PE",

joinColumns= {
		@JoinColumn(name="project_id",referencedColumnName="p_id",nullable=false)//we are not able to give directly optional=false in many to many 
},                                                                               //bcoz it have join table 
inverseJoinColumns= {
		@JoinColumn(name="employee_id",referencedColumnName="e_id",nullable=false)
})
private List<Employee> emp;

@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
@JoinColumn(name="p_id",unique=true)
private List<Task> tk;

public Project(Integer id, String name, String description, List<Employee> emp, List<Task> tk) {
	super();
	this.id = id;
	this.name = name;
	this.description = description;
	this.emp = emp;
	this.tk = tk;
}

public Project() {
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

public List<Employee> getEmp() {
	return emp;
}

public void setEmp(List<Employee> emp) {
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
	Project other = (Project) obj;
	return Objects.equals(description, other.description) && Objects.equals(emp, other.emp)
			&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(tk, other.tk);
}





}
