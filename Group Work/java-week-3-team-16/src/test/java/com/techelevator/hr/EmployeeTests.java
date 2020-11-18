package com.techelevator.hr;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.hr.Employee;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class EmployeeTests {

    @Test
    public void getFullNameReturnsCorrectFormat() {
        Employee employee = new Employee("Test", "Testerson");
        String fullName = employee.getFullName();

        assertEquals("The employee full name is not in the correct format.", "Testerson, Test", fullName);
    }

    @Test
    public void raiseSalaryTest_Positive() {
        Employee employee = new Employee("Test", "Testerson");
        employee.setSalary(100);
        employee.raiseSalary(5);

        assertEquals("The employee raise of 5% was not computed correctly.",employee.getSalary(), 100 * 1.05, 0.0);
    }

    @Test
    public void raiseSalaryTest_Negative() {
        Employee employee = new Employee("Test", "Testerson");
        employee.setSalary(100);
        employee.raiseSalary(-10); //"raise" by negative 10%

        assertEquals("Salary should remain the same when raise percentage is negative.",100, employee.getSalary(),0.0);
    }


    
   
    	@Test
    	public void test_for_get_balance_Employee() {
    		
    		Map<String, Double> test = new HashMap <String, Double>();
    		
    		test.put("Neutering", 20.0);
    		test.put("Haircut", 80.0);
    		test.put("Nail Trimming", 30.0);
    		
    		Employee objectToTest = new Employee();
    		
    		Double output = objectToTest.getBalanceDue(test);
    		
    		Assert.assertEquals(65.00, output, 0);
    		
    	}
    }

