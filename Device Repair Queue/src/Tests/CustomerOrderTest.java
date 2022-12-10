package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import RepairQueueMain.*;


class CustomerOrderTest  {
	
	 @Test
	 @DisplayName("Tests output of toString method when option 1 is selected and customer name entered is 'John Boy'")
	    public void testToStringOptionOneSelected()
	    {
		 CustomerOrder customerOrderTester = new CustomerOrder(1, "John Boy", 1);  //creating new CustomerOrder object for simulating a customer entry
	        String expected = "Customer: John Boy, Device Issue: iPhone Shattered Rear Camera"; //the expected value
	        assertEquals(expected, customerOrderTester.toString());

	    }
	 
	 
	 @Test
	 @DisplayName("Tests output of toString method when option 2 is selected and customer name entered is 'Василий - Vasily'")
	    public void testToStringOptionTwoSelected()
	    {
		 CustomerOrder customerOrderTester = new CustomerOrder(2, "Василий - Vasily", 1);  //creating new CustomerOrder object for simulating a customer entry
	        String expected = "Customer: Василий - Vasily, Device Issue: Shattered iPhone screen"; //the expected value
	        assertEquals(expected, customerOrderTester.toString());

	    }
	 
	 
	 
	 @Test
	 @DisplayName("Tests output of toString method when option 3 is selected and customer name entered is 'Василий - Vasily'")
	    public void testToStringOptionThreeSelected()
	    {
		 CustomerOrder customerOrderTester = new CustomerOrder(3, "Василий - Vasily", 1);  //creating new CustomerOrder object for simulating a customer entry
	        String expected = "Customer: Василий - Vasily, Device Issue: iPhone Logic Board Failure"; //the expected value
	        assertEquals(expected, customerOrderTester.toString());

	    }
	 
	 
	 @Test
	 @DisplayName("Tests output of toString method when option 4 is selected and customer name entered is 'Janine'")
	    public void testToStringOptionFourSelected()
	    {
		 CustomerOrder customerOrderTester = new CustomerOrder(4, "Janine", 2); //creating new CustomerOrder object for simulating a customer entry
	        String expected = "Customer: Janine, Device Issue: MacBook Pro Top Case Replacement"; //the expected value
	        assertEquals(expected, customerOrderTester.toString());

	    }
	 
	 
	 @Test
	 @DisplayName("Tests output of toString method when option 5 is selected and customer name entered is 'Alice'")
	    public void testToStringOptionFiveSelected()
	    {
		 CustomerOrder customerOrderTester = new CustomerOrder(5, "Alice", 3); //creating new CustomerOrder object for simulating a customer entry
	        String expected = "Customer: Alice, Device Issue: MacBook Pro Logic Board Replacement"; //the expected value
	        assertEquals(expected, customerOrderTester.toString());

	    }
	 
	 
	 
	 
	 @Test
	 @DisplayName("Tests output of toString method when option 6 is selected and customer name entered is 'Joe'")
	    public void testToStringOptionSixSelected()
	    {
		 CustomerOrder customerOrderTester = new CustomerOrder(6, "Joe", 4); //creating new CustomerOrder object for simulating a customer entry
	        String expected = "Customer: Joe, Device Issue: MacBook Pro Screen Replacement"; //the expected value
	        assertEquals(expected, customerOrderTester.toString());

	    }
	 
	 
	 
        //Testing fails - tests with invalid input
	 
	 //remove comment below to activate test
	// @Test 
     @DisplayName("Tests output of toString method when option 1 is selected and customer name entered is 'John'")
	    public void testToStringOptionSixSelectedFailer()
	    {
		 CustomerOrder customerOrderTester = new CustomerOrder(1, "John", 5); //creating new CustomerOrder object for simulating a customer entry
	        String expected = "Customer: Joe, Device Issue: MacBook Pro Screen Replacement"; //the expected value wrong for the value of 1 which is iPhone Shattered Rear Camera not MBP screen replacement
	        assertEquals(expected, customerOrderTester.toString());

	    
	    }
	 
	
	
	
}
