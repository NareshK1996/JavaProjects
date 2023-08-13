     package in.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.boot.bindings.EmployeeResponse;
import in.boot.entity.Employee;
import in.boot.exception.EmployeeNotFoundException;
import in.boot.reposiotry.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Long creatEmployee(Employee employee) {
		Employee isSaved = repo.save(employee);
		if (isSaved.getEId() != null) {
			return isSaved.getEId();
		}
		return null;
	}

	@Override
	public List<Employee> fetchingAllEmployees() {
		List<Employee> lists = repo.findAll();
		if (!lists.isEmpty()) {
			return lists;
		}
		return null;
	}

	@Override
	public EmployeeResponse fetchEmployeeById(Long Id) {
		EmployeeResponse response = new EmployeeResponse();
		Optional<Employee> opt = repo.findById(Id);
		if (opt.isPresent()) {
			Employee employ = opt.get();
			BeanUtils.copyProperties(employ, response);
			return response;
		} else
			throw new EmployeeNotFoundException("Employee DoesNot Exist with" + Id);
	}
	@Override
	public void deleteEmployeeById(Long Id) {

		Optional<Employee> opt = repo.findById(Id);

		if (opt.isPresent()) {
			repo.deleteById(Id);
		} else
			throw new EmployeeNotFoundException("Employee Doesnot Exist with"+Id);
	}

	@Override
	public Long updateEmployeeById(Employee employee) {
	
		       Long getId= employee.getEId();
		       if(getId!=null & repo.existsById(getId))
		       {
		    	   Employee isUpdated=repo.save(employee);
		    	   return isUpdated.getEId();
		       }else
		    	   throw new EmployeeNotFoundException("No Employee Found With"+getId);		
	}

	@Transactional
	public Long updateEmployeePassword(String empPassword,Long empMobile) {
		{
		return	repo.updatePassword(empPassword, empMobile);
		}
		}

	

	
	}
		
               

		
		
		
		
		
		
		
		
		
		
		
		
	/* Optional<Employee> opt = repo.findById(Id);
	if (opt.isPresent())
	{
	   Employee employee=opt.get();
	   BeanUtils.copyProperties(employee, response);
	   return response;
	}
	else
		throw new EmployeeNotFoundException("Employee with"+Id+"Does Not Exist");*/
	
	

	
		
	











// here EmployeeServiceImpl and IEmployee has Is A Relationship
// and HAS A Relationship with repository:

//here Optional is a class introduced in 1.8 java to 
//avoid NullpointerException we can send Null as well and UserDefinedException