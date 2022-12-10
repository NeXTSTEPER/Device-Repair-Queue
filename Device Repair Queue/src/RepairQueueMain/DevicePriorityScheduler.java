/***************************************************************
* Name : DevicePriorityScheduler 
* Author: Alex Cox
* Created : 11/25/2022
* Course: CIS 152 - Data Structures
* Version: 1.3
* OS: Windows 11 Virtual Machine on macOS 13 Ventura 
* IDE: Eclipse Version: 2022-06 (4.24.0)
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Description :  This class is the primary class of the program - it is primarily responsible for implementing the GUI and bringing in data from the CustomerOrder 
* and accompanying CustomerOrderComparator class
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/
package RepairQueueMain;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class DevicePriorityScheduler extends JFrame {
  /**
   * The text area which is used for displaying logging information.
   */
  private JTextArea textArea; //textarea for console output in a GUI
  private JTextField textField; //creating textfield for customer name entry
  @SuppressWarnings("unused")
private PrintStream standardOut;
 int insertion = 0; //Track insertion point in queue for tie breaking
  //Declaring Jbuttons for GUI
  JButton jButton = new JButton("Add Customer"); 
  JButton jButtonResults = new JButton("Sort by job priority");
  JButton jButtonClear = new JButton("Clear");
  public DevicePriorityScheduler() {
  	
  	
      super("Device Repair Queue"); //Label program window
      super.setResizable(true); //allows for resizing
      textArea = new JTextArea(50, 10);
      textArea.setEditable(false); //prevents user tampering with output
      PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
    
      // keeps reference of standard output stream
      standardOut = System.out;
      
      //choices for dropdown in the form of an array
      String[] choices = { "Shattered iPhone screen ", "iPhone Logic Board Failure", "iPhone Shattered Rear Camera", "MacBook Pro Logic Board Replacement",
              "MacBook Pro Top Case Replacement", "MacBook Pro Screen Replacement" }; 
      
      //adds dropdown
      JComboBox<String> jComboBox = new JComboBox<>(choices); 
      
      // re-assigns standard output stream and error output stream
      System.setOut(printStream);
      System.setErr(printStream);

      // creates the GUI
      setLayout(new GridBagLayout());
      GridBagConstraints constraints = new GridBagConstraints(); //Constraints for dropdown 
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.insets = new Insets(10, 10, 10, 10);
      constraints.anchor = GridBagConstraints.WEST;
      
      
      GridBagConstraints constraintsSecondary = new GridBagConstraints(); //Constraints for textfield
      constraintsSecondary.gridx = 0;
      constraintsSecondary.gridy = 0;
      constraintsSecondary.insets = new Insets(60, 10, 10, 10);
      constraintsSecondary.anchor = GridBagConstraints.EAST;
      
      GridBagConstraints constraintsClear = new GridBagConstraints(); //constraints for clear button
      constraintsClear.gridx = 1;
      constraintsClear.gridy = 2;
      constraintsClear.insets = new Insets(5, 10, 10, 10);
      constraintsClear.anchor = GridBagConstraints.EAST;
      
      
      GridBagConstraints constraintsSort = new GridBagConstraints(); //constraints for sort button
      constraintsSort.gridx = 1;
      constraintsSort.gridy = 0;
      constraintsSort.insets = new Insets(5, 10, 10, 10);
      constraintsSort.anchor = GridBagConstraints.EAST;
      
      GridBagConstraints constraintsAdd = new GridBagConstraints(); //constraints for add button
      constraintsAdd.gridx = 1;
      constraintsAdd.gridy = 0;
      constraintsAdd.insets = new Insets(5, 10, 10, 10);
    
       
      //Adds drop down label
      add(jComboBox, constraints);
    
      add(jButton,constraintsAdd); //Adds button for entering info
      add(jButtonResults, constraintsSort);
      add(jButtonClear, constraintsClear);
      
      
      constraintsSecondary.fill=GridBagConstraints.HORIZONTAL;
      textField = new JTextField("Customer Name"); //Textfield for name of customer
      textField.setBounds(10, 10, 10, 10);
      add(textField,constraintsSecondary);
      
      constraints.gridx = 1;
      constraints.gridx = 0;
      constraints.gridy = 1;
      constraints.gridwidth = 2;
      constraints.fill = GridBagConstraints.BOTH;
      constraints.weightx = 1.0;
      constraints.weighty = 1.0;
      
     
      add(new JScrollPane(textArea), constraints); //area for console output
      
     //Creates new Priority Queue from CustomerOrder class called customerOrders
      Queue<CustomerOrder> customerOrders = new PriorityQueue<>(new CustomerOrderComparator());

      //results button - this outputs sorted customer queue
      jButtonResults.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  int index= customerOrders.size();
        	 
        	 if(customerOrders.isEmpty()) { //if customer repair queue is empty
       	      System.out.println("Customer Repair Queue is empty.");
       	      System.out.println(); //Aesthetic Spacer
        	 }
        	
        	 else { //else it displays ordered priority queue
        	 System.out.println(); //Aesthetic Spacer
        	 System.out.println("Customer Repair Queue Sorted by Priority"); //prints sorted queue while emptying via poll()
        	 while (index >= 1) {
              	 index--;
             	System.out.println(customerOrders.poll());
              }
        	 System.out.println("-------------------"); //Aesthetic Spacer
        	 System.out.println("Queue Sorted: Ready for next Queue");
        	 System.out.println(); //Aesthetic Spacer
        	 }
          }
       });
      
      
      jButtonClear.addActionListener(new ActionListener() { //Implements Clear button logic - clears text area and any queue
          public void actionPerformed(ActionEvent e) {
        	 	textArea.setText("");
        	 	 int index= customerOrders.size();
        	 	 while (index >= 1) {
                  	 index--;
                 	customerOrders.poll();
                  }
          }
       });

      //Action listener for add button which adds new customer
      jButton.addActionListener(new ActionListener() {
          @Override
     
          public void actionPerformed(ActionEvent e) {
        
          	String nameEntered = textField.getText();//variable stores whatever is typed in customer name textfield
            String damagedSelected = jComboBox.getItemAt(jComboBox.getSelectedIndex()); //stores whatever in dropdown list is selected
             
            if (textField.getText().trim().isEmpty()) { //Validation to check if name or something at all is entered
                System.out.println("No customer name entered");
            }else {  
            	
            //If structure for determining what user selected in dropdown menu
              if(damagedSelected == "Shattered iPhone screen " ) {
            	 insertion = insertion + 1;
            	  customerOrders.add(new CustomerOrder(2,nameEntered, insertion));
                	System.out.println("Customer: " + nameEntered + " added");
                	textField.setText("");
              } 
              
              if(damagedSelected == "iPhone Logic Board Failure") {
             	 insertion = insertion + 1;
            	  customerOrders.add(new CustomerOrder(3,nameEntered, insertion));
                	System.out.println("Customer: " + nameEntered + " added");
                	textField.setText("");
              }
              if(damagedSelected == "iPhone Shattered Rear Camera") {
             	 insertion = insertion + 1;
            	  customerOrders.add(new CustomerOrder(1,nameEntered, insertion ));
                	System.out.println("Customer: " + nameEntered + " added");
                	textField.setText("");
                
              }
              
              if(damagedSelected == "MacBook Pro Logic Board Replacement"  ) {
             	 insertion = insertion + 1;
            	  customerOrders.add(new CustomerOrder(5,nameEntered, insertion));              	
              	System.out.println("Customer: " + nameEntered + " added");
              	textField.setText("");
              }
              
           
              if(damagedSelected == "MacBook Pro Top Case Replacement") {
             	 insertion = insertion + 1;
               	 customerOrders.add(new CustomerOrder(4,nameEntered, insertion));              	
                	System.out.println("Customer: " + nameEntered + " added");
                	textField.setText("");
               }
              
              if(damagedSelected == "MacBook Pro Screen Replacement") {
             	 insertion = insertion + 1;
                 customerOrders.add(new CustomerOrder(6, nameEntered, insertion));              	
                 System.out.println("Customer: " + nameEntered + " added");
                 textField.setText("");
                }
           }	
          	
          }
          
      });
      
      //Window behavior 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//program exits when exit 'X' is clicked
      setSize(800, 375); //sets size
      setLocationRelativeTo(null);// centers on screen
  }
  
  //output stream class to display console output to textarea in GUI
  public class CustomOutputStream extends OutputStream { 
      private JTextArea textArea;
      public CustomOutputStream(JTextArea textArea) {
          this.textArea = textArea;
      }
       
      @Override
      public void write(int b) throws IOException {
          // redirects data to the text area
          textArea.append(String.valueOf((char)b));
          // scrolls the text area to the end of data
          textArea.setCaretPosition(textArea.getDocument().getLength());
      }
  }
  
}