package in.boot.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
	
	private Long eId;
	private String empName;
	private String empEmail;
	private Long   empMobile;
	private String address;

}
