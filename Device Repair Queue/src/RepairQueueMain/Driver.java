/***************************************************************
* Name : Driver
* Author: Alex Cox
* Created : 12/01/2022
* Course: CIS 152 - Data Structures
* OS: Windows 11 Virtual Machine on macOS 13 Ventura 
* IDE: Eclipse Version: 2022-06 (4.24.0)
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Description :  Driver class
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/
package RepairQueueMain;
import javax.swing.SwingUtilities;

public class Driver {
	 //main to run program
	  public static void main(String[] args) {
	      SwingUtilities.invokeLater(new Runnable() {
	          @Override
	          public void run() {
	              new DevicePriorityScheduler().setVisible(true);
	          }
	      });
	  }
}