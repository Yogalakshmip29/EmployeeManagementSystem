package com.example.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.AddressDTO;
import com.example.dto.EmployeeDTO;
import com.example.dto.ProjectDTO;
import com.example.entity.Address;
import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.entity.Project;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.AddressRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.ProjectRepository;

@Service(value="emp")
@Transactional
public class EmployeeServiceImpl {

	
	
	@Autowired
	private EmployeeRepository erep;
	@Autowired
	private DepartmentRepository drep;
	@Autowired
	private AddressRepository arep;
	@Autowired
	private ProjectRepository prep;
	
	
	@CachePut(value="cache1",key="#edt.id")
	@Scheduled(fixedRate=60000)
	public void addEmployee(EmployeeDTO edt)throws ResourceNotFoundException {
		
		Employee emp=new Employee();
		emp.setId(edt.getId());
		emp.setName(edt.getName());
		emp.setEmail(edt.getEmail());
		emp.setPhoneNumber(edt.getPhoneNumber());
		if(edt.getDep()!=null)
		{
			Department dept=drep.findById(edt.getDep().getId()).orElseThrow(()-> new ResourceNotFoundException(""));
			emp.setDep(dept);
			
		}
		else
		{
			emp.setDep(null);
		}
		if(edt.getAddress()!=null) {
			Address address=arep.findById(edt.getAddress().getId()).orElseThrow(()->new ResourceNotFoundException(""));
			
			emp.setAddress(address);
			
		}

		List<ProjectDTO> dt=edt.getProject();
		
		
		if(dt.isEmpty()) {
			throw new ResourceNotFoundException("");
		}//validation
		
		
		List<Project> pr=new ArrayList<>();
		dt.forEach(c-> {    
		
			
	try {
	Project	project=prep.findById(c.getId()).orElseThrow(()->new Exception(""));
		pr.add(project);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		});
		
		emp.setProject(pr);
		
		erep.save(emp);
	}
	
	
	

	@Cacheable(key="#id")
	public Employee get(Integer id) throws ResourceNotFoundException {
		
		Optional<Employee> optional=erep.findById(id);
		Employee emp=optional.orElseThrow(()->new ResourceNotFoundException(""));
		return emp;
		
		
	}
	
	
	public Employee get1(Integer id) throws ResourceNotFoundException {
		Optional<Employee> optional=erep.findById(id);
		Employee emp=optional.orElseThrow(()->new ResourceNotFoundException(""));
        if(emp.getAddress()==null) {
        	throw new ResourceNotFoundException("");

        }
        return emp;
		
	}
	
}
