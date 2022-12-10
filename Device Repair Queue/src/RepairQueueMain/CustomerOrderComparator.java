/***************************************************************
* Name : CustomerOrderComparator class 
* Author: Alex Cox
* Created : 12/4/2022
* Course: CIS 152 - Data Structures
* Version: 1.3
* OS: Windows 11 Virtual Machine on macOS 13 Ventura 
* IDE: Eclipse Version: 2022-06 (4.24.0)
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Description : Class that does the sorting via comparator
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/
package RepairQueueMain;
import java.util.Comparator;

public class CustomerOrderComparator implements Comparator<CustomerOrder> {

      public int compare(CustomerOrder o1, CustomerOrder o2) {
    
          if (o1.getPriority() != o2.getPriority()) {  //If priority values are NOT equal
        	  //Check priority
        	  if(o1.getPriority() < o2.getPriority()){
        	        return 1;
        	    }
        	  if(o1.getPriority() > o2.getPriority()){
        	        return -1;
        	    }
          }  
          else {  //if priorities are equal then it checks insertion point
              return o1.getInsertion() - o2.getInsertion();  
          }
		return 0;  
      }
  }