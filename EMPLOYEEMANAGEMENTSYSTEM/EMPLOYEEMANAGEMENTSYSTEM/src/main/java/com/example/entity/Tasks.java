package com.example.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.enumerations.Status;


@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    @Column(nullable=false)
	private String name;
	private String description;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="p_id")
	private Project proj;
	
	
	
	public Tasks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tasks(Integer id, String name, String description, Status status, Project proj) {
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
	public Project getProj() {
		return proj;
	}
	public void setProj(Project proj) {
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
		Tasks other = (Tasks) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(proj, other.proj) && status == other.status;
	}
	@Override
	public String toString() {
		return "Tasks [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ", proj="
				+ proj + "]";
	}
	
	
}

	
