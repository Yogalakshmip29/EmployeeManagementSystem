package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.DepartmentDTO;
import com.example.dto.EmployeeDTO;
import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.AddressRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.ProjectRepository;



@Service(value="dept")
@Transactional
@CacheConfig(cacheNames="cache1")
public class DepartmentServiceImpl {

	@Autowired
	private EmployeeRepository erep;
	@Autowired
	private DepartmentRepository drep;
	@Autowired
	private AddressRepository arep;
	@Autowired
	private ProjectRepository prep;
	

	public void add(DepartmentDTO dep) throws ResourceNotFoundException {
		Department d=new Department();
		d.setId(dep.getId());
		d.setName(dep.getName());
		
		List<Employee> em=new ArrayList<>();
		List<EmployeeDTO> dt=dep.getEmployee();
		if(dt.isEmpty())
		{
			throw new ResourceNotFoundException("");
		}
		
		dt.forEach(c->  {
			try {
			Employee emp=erep.findById(c.getId()).orElseThrow(()->new ResourceNotFoundException(""));
				em.add(emp);
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
			
		});
		d.setEmployee(em);
		drep.save(d);
		
	}
}
