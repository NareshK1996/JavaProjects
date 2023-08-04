package in.boot.service;

import java.util.List;

import in.boot.bindings.EmployeeResponse;

//import java.util.List;

import in.boot.entity.Employee;

public interface IEmployeeService {
	
	public Long creatEmployee(Employee employee);
	public List<Employee> fetchingAllEmployees();
	public EmployeeResponse fetchEmployeeById(Long Id);
	public  void deleteEmployeeById(Long Id);
//	public EmployeeResponse updatedEmployeeById(EmployeeResponse  response);
	
	
}
