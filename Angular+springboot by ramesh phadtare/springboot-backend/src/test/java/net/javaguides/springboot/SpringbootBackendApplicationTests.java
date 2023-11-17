package net.javaguides.springboot;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import net.javaguides.springboot.entity.Employee;
import net.javaguides.springboot.controller.EmployeeController;
import net.javaguides.springboot.repository.EmployeeRepository;

@SpringBootTest
class SpringbootBackendApplicationTests {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	
	@Test
	@Disabled    //for skipping this test
	public void testGetAllEmployees() {
		MockitoAnnotations.initMocks(this);
		
		Employee e1=new Employee(1L,"sachin","ghatage","sachin@123");
		Employee e2=new Employee(2L,"karan","patil","karan@123");
		List<Employee> mockEmployees = Arrays.asList(e1,e2);
		
		when(employeeRepository.findAll()).thenReturn(mockEmployees);
		
		List<Employee> result = employeeController.getAllEmployees();
		
		 // Assertions for the first employee
		assertNotNull(result.get(0).getFirstName());
	    assertEquals(mockEmployees.get(0).getFirstName(), result.get(0).getFirstName());
	    assertEquals(mockEmployees.get(0).getLastName(), result.get(0).getLastName());
	    assertEquals(mockEmployees.get(0).getEmailId(), result.get(0).getEmailId());

	    // Assertions for the second employee
	    assertEquals(mockEmployees.get(1).getFirstName(), result.get(1).getFirstName());
	    assertEquals(mockEmployees.get(1).getLastName(), result.get(1).getLastName());
	    assertEquals(mockEmployees.get(1).getEmailId(), result.get(1).getEmailId());	
	    }
	
	
	
	@Test
	public void testCreateEmployee() {
		MockitoAnnotations.initMocks(this);
		
		Employee newEmployee=new Employee();
		newEmployee.setFirstName("sachin");
		newEmployee.setLastName("ghatage");
		newEmployee.setEmailId("sachin@123");
		
		when(employeeRepository.save(newEmployee)).thenReturn(newEmployee);
		
		Employee savedEmployee = employeeController.createEmployee(newEmployee);
		
		verify(employeeRepository).save(newEmployee);
		
		assertEquals(newEmployee.getFirstName(), savedEmployee.getFirstName());
        assertEquals(newEmployee.getLastName(), savedEmployee.getLastName());
        assertEquals(newEmployee.getEmailId(), savedEmployee.getEmailId());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
