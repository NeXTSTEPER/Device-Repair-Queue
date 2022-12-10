package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import RepairQueueMain.*;

class CustomerOrderComparatorTest {

	CustomerOrderComparator customerComparer = new CustomerOrderComparator();

	@Test
    public void testTakeOne() {
		CustomerOrder customerOrderTester = new CustomerOrder(1, "James Yung",5);
		CustomerOrder customerOrderTesterTwo = new CustomerOrder(2, "Barclay", 6);        
		int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
		assertEquals(1 , result);
    }

	@Test
    public void testTakeTwo() {
		CustomerOrder customerOrderTester = new CustomerOrder(2, "John Boy", 1);
		CustomerOrder customerOrderTesterTwo = new CustomerOrder(2, "John Boy", 2);        
		int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
		assertEquals(-1 , result);
    }
	
	@Test
	 public void testTakeThree() {
			CustomerOrder customerOrderTester = new CustomerOrder(6, "James Gandolfini",3);
			CustomerOrder customerOrderTesterTwo = new CustomerOrder(5, "Tony Soprano",4);        
			int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
			assertEquals(-1 , result);
	    }
	
	@Test
	 public void testTakeFour() {
			CustomerOrder customerOrderTester = new CustomerOrder(5, "John Boy",7);
			CustomerOrder customerOrderTesterTwo = new CustomerOrder(6, "John Boy",8);        
			int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
			assertEquals(1 , result);
	    }
	
	

	@Test
	 public void testTakeFive() {
			CustomerOrder customerOrderTester = new CustomerOrder(6, "John Boy",9);
			CustomerOrder customerOrderTesterTwo = new CustomerOrder(5, "John Boy",10);        
			int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
			assertEquals(-1 , result);
	    }
	
	
    //Testing fails - tests with invalid input
	 
	 //remove comment below to activate test
	 //@Test 
	 public void testTakeSix() {
			CustomerOrder customerOrderTester = new CustomerOrder(3, "John Boy", 1);
			CustomerOrder customerOrderTesterTwo = new CustomerOrder(5, "John Boy", 2);        
			int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
			assertEquals(-1 , result);
	    }
	 
	//@Test 
	 public void testTakeSeven() {
			CustomerOrder customerOrderTester = new CustomerOrder(5, "John Boy", 3);
			CustomerOrder customerOrderTesterTwo = new CustomerOrder(3, "John Boy", 4);        
			int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
			assertEquals(1 , result);
	    }
	
}
