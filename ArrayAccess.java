// Name: Christelle Nieves

// ArrayAccess.java
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ArrayAccess extends JFrame 
{
   private JTextField inputField;
   private JTextField retrieveField1;
   private JTextField retrieveField2;
   private JTextField outputField;
   private JPanel inputArea; 
   private JPanel retrieveArea;
   private JPanel outputArea;

   private int num;
   private int index = 0;
   private int array[] = new int[ 10 ];
   private String result;
   
   // set up GUI
   public ArrayAccess()
   {
      super( "Accessing Array values" );
      setLayout( new FlowLayout() );
      
      // set up input Panel
      inputArea = new JPanel();
      inputArea.add( new JLabel( "Enter array elements here" ) );
      inputField = new JTextField( 10 );
      inputArea.add( inputField );
      inputField.addActionListener( 
         new ActionListener()
         {
            public void actionPerformed( ActionEvent e )
            {
               /* Create a try block in which the application reads the number
                  entered in the inputField and assigns it to the next index 
                  in the array, then increments instance variable index. */
               try 
               {
                  String num;
                  num = inputField.getText();
                  array[index] = Integer.parseInt(num);
                  index++;
               } 
               /* Write catch handlers that catch the two types of exceptions
                  that the previous try block might throw (NumberFormatException
                  and ArrayIndexOutOfBoundsException), and display appropriate 
                  messages in error message dialogs. */
               catch (NumberFormatException numberFormatException)
               {
                  JOptionPane.showMessageDialog(new JFrame(), "Please enter only integer values");
               }

               catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
               {
                  JOptionPane.showMessageDialog(new JFrame(), "Array may contain only 10 elements");
               }
               
               inputField.setText( "" );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener
      
      // set up retrieve Panel
      retrieveArea = new JPanel( new GridLayout( 2, 2 ) );
      retrieveArea.add( new JLabel( "Enter number to retrieve" ) );
      retrieveField1 = new JTextField( 10 );
      retrieveArea.add( retrieveField1 );
      retrieveField1.addActionListener( 
         new ActionListener() 
         {
            public void actionPerformed( ActionEvent event ) 
            {
               /* Create a try block in which the application reads from 
                  retrieveField1 the number the user wants to find in the 
                  array, then searches the current array contents for the number.
                  If the number is found, the outputField should display all the 
                  indices in which the number was found. If the number is not 
                  found, a NumberNotFoundException should be thrown. */
               
               try
               {
                  String numToFind = retrieveField1.getText();
                  boolean found = false;

                  for (int i = 0; i < array.length; i++)
                  {
                     if (array[i] == Integer.parseInt(numToFind))
                     {
                        found = true;
                        outputField.setText(Integer.toString(i));
                     }
                  }

                  if (!found)
                  {
                     throw new NumberNotFoundException();
                  }
               }
               
               /* Write catch handlers that catch the two types of exceptions that
                  the try block might throw (NumberFormatException and 
                  NumberNotFoundException), and display appropriate messages 
                  in error message dialogs. */
               catch (NumberFormatException numberFormatException)
               {
                  JOptionPane.showMessageDialog(new JFrame(), "Please enter only integer values");
               }

               catch (NumberNotFoundException numberNotFoundException)
               {
                  JOptionPane.showMessageDialog(new JFrame(), "Number not found in array");
               }
                
               retrieveField1.setText( "" );
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener
            
      retrieveArea.add( new JLabel( "Enter index to retrieve" ) );
      retrieveField2 = new JTextField( 10 );
      retrieveArea.add( retrieveField2 );
      retrieveField2.addActionListener(
         new ActionListener() 
         {
            public void actionPerformed( ActionEvent event )
            {
               /* Create a try block in which the application reads from 
                  retrieveField2 the index of a value in the array, then 
                  displays the value at that index in the outputField. If the index
                  input by the user is not a number a NumberFormatException should
                  be thrown. If the number input by the user is outside the array 
                  bounds or represents an element in which the application has not
                  stored a value, an ArrayIndexOutOfBoundsException should 
                  be thrown. */

               try
               {
                  String indxString = retrieveField2.getText();
                  int indx = Integer.parseInt(indxString);

                  if (indx > 9)
                  {
                     throw new ArrayIndexOutOfBoundsException();
                  }

                  result = Integer.toString(array[indx]);
                  outputField.setText(result);
               }
               
               /* Write catch handlers that catch the two types of exceptions
                  the try block might throw (NumberFormatException and 
                  ArrayIndexOutOfBoundsException), and display appropriate 
                  messages in error message dialogs. */
               catch (NumberFormatException numberFormatException)
               {
                  JOptionPane.showMessageDialog(new JFrame(), "Please enter only integer values");
               }

               catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
               {
                  JOptionPane.showMessageDialog(new JFrame(), "Index not found");
               }
               
               retrieveField2.setText( "" );
            } // end anonymous inner class
         } // end new ActionListener
      ); // end call to addActionListener
      
      // set up output Panel
      outputArea = new JPanel();
      outputArea.add( new JLabel( "Result" ) );
      outputField = new JTextField( 30 );
      outputField.setEditable( false );
      outputArea.add( outputField );

      add( inputArea );
      add( retrieveArea );
      add( outputArea );
   }  // end constructor
} // end class ArrayAccess