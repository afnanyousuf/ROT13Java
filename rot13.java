





import javax.swing.*; // ui
import java.awt.*; //interface
import java.awt.event.*; //event handling

 
import java.util.Arrays; //import scanner for input
//class rot13
public class rot13 extends JFrame implements ActionListener {
 public static String userInput; //input string
 public static int length; //length of string
 private JTextField input;
 private JTextField output;
 private JButton crypt;
 
 public rot13(){
 setSize(250,150);//set gui size
 setTitle("Rot13 Encrypt/Decrypt"); //set title
 setLayout(new FlowLayout());//sets layout of native OS
 //input fields
 input = new JTextField(10);
 output = new JTextField(20);
 output.setEditable(false);
 //cryption button
 crypt = new JButton("Encrypt/Decrypt");
 //add elements to jframe
 add(new JLabel("Enter text to be Encrypted or Decrypted"));
 add(input);
 add(crypt);
 add(new JLabel("<html><br><br></html>"));
 add(output);
 setVisible(true);
 crypt.addActionListener(this); //add actionlistener for button
  
}

public void actionPerformed(ActionEvent e)
 {
  //if button pessed 
  if(e.getSource()==crypt){
    //if input is empty, error message
   if(input.getText().isEmpty()){
    JOptionPane.showMessageDialog(null,
    "Invalid input",
    "Error",
    JOptionPane.ERROR_MESSAGE); 

   }
   
   else{
     //change input to uppercase
     userInput = input.getText().toUpperCase();
     length=userInput.length(); //get length of input
    char[] characters = new char[length]; //new character array with length of input
  //loop inserts charcters from input into the array
  for(int i=0;i<length;i++){
   characters[i] = userInput.charAt(i);
  }
  //loop through charcter array and change the letter according to position of letter
 for(int i=0;i<characters.length;i++){
   //if letter is in between/at a and m
   if(characters[i] >= 'A' && characters[i] <= 'M' ){
     characters[i]+=13; //move it 13 letters forward
   }
   //if letter is in between/at n and z
     else if ( characters[i] >= 'N' && characters[i] <='Z'){
      characters[i]-=13; //move it 13 letter behind
     }
     //create a new string with the character array
     String f = new String(characters);
     //output the encrypted/decrypted message
     output.setText(f);
}
   }
  

  }

 }
 public static void main(String[] args) {
  new rot13(); //initialize gui
  
  
}//end main()


}//end class