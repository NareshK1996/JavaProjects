/**
 * 
 */
package in.boot.exception;

/** when employee Data Not Found in DataBase
 * we send one message to the user such no record 
 * found with that Id
 * @author Dell
 *
 */
public class EmployeeNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;
	public EmployeeNotFoundException()
	{
		super();
	}
     public EmployeeNotFoundException(String msg)
     {
    	 super(msg);
     }
}
