package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;
@Repository(value="rep4")
public interface TaskRepository extends JpaRepository<Task,Integer> {

}
