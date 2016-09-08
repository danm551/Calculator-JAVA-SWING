import javax.swing.*;
import java.awt.event.*;

public class CalcButtonListener implements ActionListener {
	JTextField screen = new JTextField();
	String outputString = "", currNumString = "", currOperation = "";
	int currNum, result = 0, numOrSymbol;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setScreen();
		
		//if number, keep printing to screen, otherwise add space and symbol
		if(e.getActionCommand().matches("[0-9]")){
			outputString += e.getActionCommand();
			currNumString += e.getActionCommand();
		
			screen.setText(outputString);
			
			numOrSymbol = 0;
		}
		else if(e.getActionCommand().matches("[+-/*]") && numOrSymbol == 0){
			currNum = new Integer(currNumString); //casts the currNum string into an integer
			outputString += " " + e.getActionCommand() + " "; //saves the symbol into outputString
			currNumString = ""; //clears currNumString
			
			if(currOperation == "+"){
				result += currNum;
			}
			else if(currOperation == "-"){
				if(result == 0){
					result = currNum;
				}
				else{
					result -= currNum;
				}
			}
			else if(currOperation == "*"){
				if(result == 0){
					result = currNum;
				}
				else{
					result *= currNum;
				}
			}
			else if(currOperation == "/"){
				//try/catch for division by 0
				try{
					if(result == 0)
						result = currNum;
					else
						result /= currNum;
				}
				catch(ArithmeticException error){
					System.out.println("Attempting to divide by zero.");
				}
			}
			else{
				result = currNum;
			}
			
			//saves the current operation for processing final number
			if(e.getActionCommand() == "+"){
				currOperation = "+";
			}
			else if(e.getActionCommand() == "-"){
				currOperation = "-";
			}
			else if(e.getActionCommand() == "*"){
				currOperation = "*";
			}
			else{
				currOperation = "/";
			}
			
			screen.setText(outputString);
			
			numOrSymbol = 1;
		}
		else if(e.getActionCommand() == "C"){
			outputString = "";
			result = 0;
			currNum = 0;
			currNumString = "";
			screen.setText("");
			
			screen.setText(outputString);
		}
		else if(e.getActionCommand() == "="){
			if(currOperation == "+"){
				System.out.println("currNumString: " + currNumString);
				result += new Integer(currNumString);
				outputString = new Integer(result).toString();
				screen.setText(outputString);
			}
			else if(currOperation == "-"){
				result -= new Integer(currNumString);
				outputString = new Integer(result).toString();
				screen.setText(outputString);
			}
			else if(currOperation == "*"){
				result *= new Integer(currNumString);
				outputString = new Integer(result).toString();
				screen.setText(outputString);
			}
			else{
				try{
					result /= new Integer(currNumString);
					outputString = new Integer(result).toString();
					screen.setText(outputString);
				}
				catch(ArithmeticException error){
					screen.setText("ERROR: Division by Zero");
				}
			}
			
			currNum = 0;
			currNumString = "";
			result = 0;
			outputString = "";
		}	
	}
	
	public void setScreen(){
		screen = CalcInterface.getScreen();
	}
}
