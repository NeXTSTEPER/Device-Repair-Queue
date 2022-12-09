package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import RepairQueueMain.*;

class CustomerOrderComparatorTest {

	CustomerOrderComparator customerComparer = new CustomerOrderComparator();

	@Test
    public void testTakeOne() {
		CustomerOrder customerOrderTester = new CustomerOrder(1, "James Yung");
		CustomerOrder customerOrderTesterTwo = new CustomerOrder(2, "Barclay");        
		int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
		assertEquals(1 , result);
    }

	@Test
    public void testTakeTwo() {
		CustomerOrder customerOrderTester = new CustomerOrder(2, "John Boy");
		CustomerOrder customerOrderTesterTwo = new CustomerOrder(2, "John Boy");        
		int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
		assertEquals(-1 , result);
    }
	
	@Test
	 public void testTakeThree() {
			CustomerOrder customerOrderTester = new CustomerOrder(6, "James Gandolfini");
			CustomerOrder customerOrderTesterTwo = new CustomerOrder(5, "Tony Soprano");        
			int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
			assertEquals(-1 , result);
	    }
	
	@Test
	 public void testTakeFour() {
			CustomerOrder customerOrderTester = new CustomerOrder(5, "John Boy");
			CustomerOrder customerOrderTesterTwo = new CustomerOrder(6, "John Boy");        
			int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
			assertEquals(1 , result);
	    }
	
	

	@Test
	 public void testTakeFive() {
			CustomerOrder customerOrderTester = new CustomerOrder(6, "John Boy");
			CustomerOrder customerOrderTesterTwo = new CustomerOrder(5, "John Boy");        
			int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
			assertEquals(-1 , result);
	    }
	
	
    //Testing fails - tests with invalid input
	 
	 //remove comment below to activate test
	 //@Test 
	 public void testTakeSix() {
			CustomerOrder customerOrderTester = new CustomerOrder(3, "John Boy");
			CustomerOrder customerOrderTesterTwo = new CustomerOrder(5, "John Boy");        
			int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
			assertEquals(-1 , result);
	    }
	 
	//@Test 
	 public void testTakeSeven() {
			CustomerOrder customerOrderTester = new CustomerOrder(5, "John Boy");
			CustomerOrder customerOrderTesterTwo = new CustomerOrder(3, "John Boy");        
			int result = customerComparer.compare(customerOrderTester, customerOrderTesterTwo);
			assertEquals(1 , result);
	    }
	
}
