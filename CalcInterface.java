import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension; 
import java.awt.Font;


public class CalcInterface extends JFrame {
	
	JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
		buttonMinus, buttonPlus, buttonMult, buttonDivision, buttonClear, buttonEquals;
	static JTextField screen;
	
	public static void main(String[] args){
		new CalcInterface();
	}
	
	public CalcInterface(){
		/* MAIN PANEL */
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainFrame = new JPanel();
		mainFrame.setLayout(new BorderLayout());

		/* SCREEN PANEL */
		screen = new JTextField("", 20);
		Font screenFont = new Font("Helvetica", Font.ITALIC, 30);
		screen.setFont(screenFont);
		screen.setPreferredSize(new Dimension(100,50));
		mainFrame.add(screen, BorderLayout.NORTH);
		
		/* BODY PANEL */
		JPanel body = new JPanel();
		body.setPreferredSize(new Dimension(100,300));
		body.setLayout(new GridBagLayout());
		GridBagConstraints bodyGBConstraints = new GridBagConstraints();
		bodyGBConstraints.gridheight = 1;
		bodyGBConstraints.gridwidth = 1; 
		bodyGBConstraints.weightx = 50;
		bodyGBConstraints.weighty = 100;
		bodyGBConstraints.insets = new Insets(5,5,5,5);
		bodyGBConstraints.anchor = GridBagConstraints.CENTER;
		bodyGBConstraints.fill = GridBagConstraints.BOTH;
		bodyGBConstraints.ipadx = 3;
		bodyGBConstraints.ipady = 50;
		
		Font buttonFont = new Font("Helvetica", Font.PLAIN, 20);
		button0 = new JButton("0");
		button0.setFont(buttonFont);
		button1 = new JButton("1");
		button1.setFont(buttonFont);
		button2 = new JButton("2");
		button2.setFont(buttonFont);
		button3 = new JButton("3");
		button3.setFont(buttonFont);
		button4 = new JButton("4");
		button4.setFont(buttonFont);
		button5 = new JButton("5");
		button5.setFont(buttonFont);
		button6 = new JButton("6");
		button6.setFont(buttonFont);
		button7 = new JButton("7");
		button7.setFont(buttonFont);
		button8 = new JButton("8");
		button8.setFont(buttonFont);
		button9 = new JButton("9");
		button9.setFont(buttonFont);
		buttonMinus = new JButton("-");
		buttonMinus.setFont(buttonFont);
		buttonPlus = new JButton("+");
		buttonPlus.setFont(buttonFont);
		buttonMult = new JButton("*");
		buttonMult.setFont(buttonFont);
		buttonDivision = new JButton("/");
		buttonDivision.setFont(buttonFont);
		buttonClear = new JButton("C");
		buttonClear.setFont(buttonFont);
		buttonEquals = new JButton("=");
		buttonEquals.setFont(buttonFont);
		
		bodyGBConstraints.gridy = 0;
		bodyGBConstraints.gridx = 0;
		body.add(button1, bodyGBConstraints);
		bodyGBConstraints.gridx = 1;
		body.add(button2, bodyGBConstraints);
		bodyGBConstraints.gridx = 2;
		body.add(button3, bodyGBConstraints);
		bodyGBConstraints.gridy = 1;
		bodyGBConstraints.gridx = 0;
		body.add(button4, bodyGBConstraints);
		bodyGBConstraints.gridx = 1;
		body.add(button5, bodyGBConstraints);
		bodyGBConstraints.gridx = 2;
		body.add(button6, bodyGBConstraints);
		bodyGBConstraints.gridy = 2;
		bodyGBConstraints.gridx = 0;
		body.add(button7, bodyGBConstraints);
		bodyGBConstraints.gridx = 1;
		body.add(button8, bodyGBConstraints);
		bodyGBConstraints.gridx = 2;
		body.add(button9, bodyGBConstraints);
		bodyGBConstraints.gridy = 3;
		bodyGBConstraints.gridx = 1;
		body.add(button0, bodyGBConstraints);
		bodyGBConstraints.gridy = 4;
		bodyGBConstraints.gridx = 0;
		body.add(buttonPlus, bodyGBConstraints);
		bodyGBConstraints.gridx = 1;
		body.add(buttonMinus, bodyGBConstraints);
		bodyGBConstraints.gridx = 2;
		body.add(buttonMult, bodyGBConstraints);
		bodyGBConstraints.gridy = 5;
		bodyGBConstraints.gridx = 0;
		body.add(buttonDivision, bodyGBConstraints);
		bodyGBConstraints.gridx = 1;
		body.add(buttonClear, bodyGBConstraints);
		bodyGBConstraints.gridx = 2;
		body.add(buttonEquals, bodyGBConstraints);
		
		CalcButtonListener buttonListener = new CalcButtonListener();
		button0.addActionListener(buttonListener);
		button1.addActionListener(buttonListener);
		button2.addActionListener(buttonListener);
		button3.addActionListener(buttonListener);
		button4.addActionListener(buttonListener);
		button5.addActionListener(buttonListener);
		button6.addActionListener(buttonListener);
		button7.addActionListener(buttonListener);
		button8.addActionListener(buttonListener);
		button9.addActionListener(buttonListener);
		buttonPlus.addActionListener(buttonListener);
		buttonMinus.addActionListener(buttonListener);
		buttonMult.addActionListener(buttonListener);
		buttonDivision.addActionListener(buttonListener);
		buttonClear.addActionListener(buttonListener);
		buttonEquals.addActionListener(buttonListener);
		
		mainFrame.add(body, BorderLayout.SOUTH);
		
		
		/* FINAL MAIN PANEL ATTRIBUTES */
		this.add(mainFrame);
		this.setVisible(true);
	}
	
	public static JTextField getScreen(){
		return screen;
	}
}
