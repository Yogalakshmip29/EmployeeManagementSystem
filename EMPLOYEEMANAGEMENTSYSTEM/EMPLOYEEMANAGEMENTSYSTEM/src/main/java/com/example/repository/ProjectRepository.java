package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
import com.example.entity.Project;

@Repository(value="rep4")
public interface ProjectRepository extends JpaRepository<Project,Integer> {

}
