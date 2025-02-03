package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.AddressDTO;
import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.AddressRepository;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.ProjectRepository;

@Service(value="addr")
@Transactional
public class AddressserviceImpl {
	@Autowired
	private EmployeeRepository erep;
	@Autowired
	private DepartmentRepository drep;
	@Autowired
	private AddressRepository arep;
	@Autowired
	private ProjectRepository prep;
	
	public void add(AddressDTO ad) throws ResourceNotFoundException {
		Address a1=new Address();
		a1.setId(ad.getId());
		a1.setName(ad.getName());
		a1.setCity(ad.getCity());
		a1.setPostalCode(ad.getPostalCode());
		if(ad.getEmployee()!=null)//validation
			{
			Employee emp=erep.findById(ad.getEmployee().getId()).orElseThrow(()->new ResourceNotFoundException(""));
		a1.setEmployee(emp);
		}
		a1.setEmployee(null);
		arep.save(a1);
	}
	
}
