package com.example.dto;

import java.util.Objects;

import javax.persistence.Column;

import com.example.enumerations.Status;




public class TasksDTO {
  
	private Integer id;
    @Column(nullable=false)
	private String name;
	private String description;
	
	private Status status;
	
	private ProjectDTO proj;
	
	
	
	public TasksDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TasksDTO(Integer id, String name, String description, Status status, ProjectDTO proj) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.proj = proj;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public ProjectDTO getProj() {
		return proj;
	}
	public void setProj(ProjectDTO proj) {
		this.proj = proj;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, proj, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TasksDTO other = (TasksDTO) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(proj, other.proj) && status == other.status;
	}
	@Override
	public String toString() {
		return "Tasks [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ", proj="
				+ proj + "]";
	}
	
	
}

	
