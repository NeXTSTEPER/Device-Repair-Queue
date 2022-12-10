/***************************************************************
* Name : CustomerOrder class 
* Author: Alex Cox
* Created : 12/3/2022
* Course: CIS 152 - Data Structures
* Version: 1.3
* OS: Windows 11 Virtual Machine on macOS 13 Ventura 
* IDE: Eclipse Version: 2022-06 (4.24.0)
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Description : This class is for creating CustomerOrder to represent as it's name suggests, Customer Orders for repair
* Includes toString method for displaying output based upon what priority of repair/damage was selected in the dropdown
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/
package RepairQueueMain;

public class CustomerOrder  {
    //variables
    private int priority;
    private String customerName;

    //parameterized constructor
    public CustomerOrder( int priority, String customerName) {
        
        this.priority = priority;
        this.customerName = customerName;
    }

   
    @Override
    public String toString() { //to string for displaying out put
    	
    	if(this.priority == 2) {
    		 return "Customer: " + customerName +", Device Issue: " + "Shattered iPhone screen";
    	}
    	
    	if(this.priority == 3) {
   		 return "Customer: " + customerName +", Device Issue: " + "iPhone Logic Board Failure";
   	}
    	
    	
    	if(this.priority == 1) {
      		 return "Customer: " + customerName +", Device Issue: " + "iPhone Shattered Rear Camera";
      	}
    	
    	
    	if(this.priority == 5) {
     		 return "Customer: " + customerName +", Device Issue: " + "MacBook Pro Logic Board Replacement";
     	}
    	
    	if(this.priority == 4) {
    		 return "Customer: " + customerName +", Device Issue: " + "MacBook Pro Top Case Replacement";
    	}
    	
    	if(this.priority == 6) {
   		return "Customer: " + customerName +", Device Issue: MacBook Pro Screen Replacement";
    		
   	}
    	
        return "";
    }

    public double getPriority() { //gets priority value
        return priority;
    }
   
}
