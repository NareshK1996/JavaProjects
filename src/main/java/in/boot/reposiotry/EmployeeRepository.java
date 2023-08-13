package in.boot.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.boot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

	@Modifying
	@Query("UPDATE Employee e SET e.empPassword=:empPassword WHERE e.empMobile=:empMobile")
	public Long updatePassword(String empPassword,Long empMobile);
}
