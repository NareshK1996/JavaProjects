package in.boot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application.properties")
 public class ApplicationTests {

	@Autowired
	private MockMvc mockmvc;
	@Test
	@DisplayName("TESTING STUDENT SAVE OPERATIONS")
	@Order(1)
	public void testsaveEmployee() throws Exception
	{
        //1.create Mocked Request
		MockHttpServletRequestBuilder request = 
		MockMvcRequestBuilders.post("http://localhost:9090/employee-service/save")
	    .contentType("application/json")
		
	    .content("{\"empName\":\"Ajay\",\"empEmail\":\"aj@gmail.com\",\"empMobile\":,\"address\":\"lbnagar\"}");
		
    //  2.Execute it and Read Result (request,response,exception)
		  MvcResult result = mockmvc.perform(request).andReturn(); 
		  
    // 3.Read Response from result	
	      MockHttpServletResponse response = result.getResponse();
	      
	// 4.Assert Result Using Junit	
	      
	      assertEquals(HttpStatus.CREATED.value(),response.getStatus());
	      assertNotNull(response.getContentAsString());
	     if( !response.getContentAsString().contains("Successfully"))
	     {
	    	 fail("EMPLOYEE NOT CREATED!");
	     }
	      
	}
	
	
	@Test
	public void m2()
	{
		
		
		MockHttpServletRequestBuilder accept = 
				MockMvcRequestBuilders.get("/employee/fetchAll")
				.accept("appliation/xml");
	}
}
