package in.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.boot.bindings.EmployeeResponse;
import in.boot.entity.Employee;
import in.boot.exception.EmployeeNotFoundException;
import in.boot.service.IEmployeeService;

@RestController
@RequestMapping("/employee-service")
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService service;
	
	/**
	 * Employee Data Saving From this PostMapping
	 * After Successful Save Operations Returning
	 * Employee ID 
	 * @param employee
	 * @return ID
	 */
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		Long Id = service.creatEmployee(employee);
		String msg = "Employee Created with" + Id + "Successfully";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<List<Employee>> showAllEmployeeDetails() {
		List<Employee> employeesList = service.fetchingAllEmployees();
		return new ResponseEntity<List<Employee>>(employeesList, HttpStatus.OK);
	}
	
	/*@GetMapping("/find/{Id}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long Id) {
		  EmployeeResponse response = service.fetchEmployeeById(Id);
		return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
	}*/
	@GetMapping("/find/{Id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long Id)
	{
		ResponseEntity<?> response=null;                                                // used at Generic it is dynamically selects introduced in java1.5
		try
		{
		EmployeeResponse fetchedById = service.fetchEmployeeById(Id);
		response= new ResponseEntity<EmployeeResponse>(fetchedById,HttpStatus.OK);
			
		}catch(EmployeeNotFoundException enfe)
		{
			throw enfe;
		}
		return response;
	}
	@DeleteMapping("/remove/{Id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long Id)
	{
		ResponseEntity<String> response = null;
		try {
			service.deleteEmployeeById(Id);
			String msg = "Employee Is Deleted with" + Id;
			response = new ResponseEntity<String>(msg, HttpStatus.OK);

		} catch (EmployeeNotFoundException enfe) {

			throw enfe;
		}
		return response;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee)
	{
		ResponseEntity<String> res = null;
		try {
			Long updatedById = service.updateEmployeeById(employee);
			res = new ResponseEntity<String>("Employee Details with" + updatedById + "Successfully", HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			throw e;

		}
		return res;
	}

	@PatchMapping("/update/{empPassword}/{empMobile}")
	public ResponseEntity<String> updatemailPassword(@PathVariable String empPassword, @PathVariable Long empMobile) {
		ResponseEntity<String> res = null;

		try {
			  Long updateEmployeePassword = service.updateEmployeePassword(empPassword, empMobile);
			res = new ResponseEntity<String>("Employee password Updated", HttpStatus.OK);
		} catch (EmployeeNotFoundException enfe) {
			throw enfe;
		}
		return res;

	}
	
}
// here static :/pathName and dynamic path:/{keyName}