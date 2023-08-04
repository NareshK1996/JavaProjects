package in.boot.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import in.boot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
