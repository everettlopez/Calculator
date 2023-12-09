import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Calculator implements ActionListener
{
	private JFrame frame;
	private JTextField textField;
	private ArrayList<JButton> numberButtons = new ArrayList<>();
	private ArrayList<JButton> functionButtons = new ArrayList<>();
	private JButton additionButton, subtractButton, multiplicationButton, divisionButton;
	private JButton decimalButton, equalsButton, deleteButton, clearButton, negativeButton;
	private JPanel panel;
	
	private Font myFont = new Font("Euphemia", 22, 22);
	
	private double number1 = 0;
	private double number2 = 0;
	private double result = 0;
	
	private char operator;
	
	public Calculator()
	{
		//This section will construct a new JFrame for the application.
		frame = new JFrame("Calculator");								//Creates a new, initially invisible Frame with thespecified title. 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//Sets the operation that will happen by default whenthe user initiates a "close" on this frame.
		frame.setSize(420, 550);										//Resizes this frame so that it has width widthand height height. 
		frame.setLayout(null);
		
		
		
		//This section will construct the textbox that will display the calculations.
		textField = new JTextField();									//Constructs a new TextField
		textField.setBounds(50, 25, 300, 50);							//Moves and resizes this text field frame.
		textField.setFont(myFont);										//Sets the current font
		textField.setEditable(false);									//Does not allow the user to edit textbox.
		
		//This section will initilaize the button variables for the calulcator.
		additionButton = new JButton("+");								//Creates a textbox displaying addition symbol.
		subtractButton = new JButton("-");								//Creates a textbox displaying subtraction symbol.
		multiplicationButton = new JButton("*");						//Creates a textbox displaying mulitiplication symbol.
		divisionButton = new JButton("/");								//Creates a textbox displaying division symbol.
		decimalButton = new JButton(".");								//Creates a textbox displaying decimal symbol.
		equalsButton = new JButton("=");								//Creates a textbox displaying equals symbol.
		deleteButton = new JButton("DEL");								//Creates a textbox delete decimal symbol.
		clearButton = new JButton("CLR");								//Creates a textbox displaying clear symbol.
		negativeButton = new JButton("(-)");							//Creates a textbox displaying negative symbol.
		
		//This section will initialize the function (operator) buttons backing array with the text boxes.
		functionButtons.add(additionButton);						
		functionButtons.add(subtractButton);
		functionButtons.add(multiplicationButton);
		functionButtons.add(divisionButton);
		functionButtons.add(decimalButton);
		functionButtons.add(equalsButton);
		functionButtons.add(deleteButton);
		functionButtons.add(clearButton);
		functionButtons.add(negativeButton);
		
		//This for-loop will traverse the entire function button structure and add a few addditional features.
		//		i.e Action Listener, Font, etc.
		for(int i = 0; i < 9; i++)
		{
			functionButtons.get(i).addActionListener(this);			
			functionButtons.get(i).setFont(myFont);
			functionButtons.get(i).setFocusable(false);
		}
		
		//This for-loop will traverse the entire number buttons structure and add the values of the buttons accordingly.
		//		i.e 0, 1, 2, 3, ... , 9.
		for(int i = 0; i < 10; i++)
		{
			
			numberButtons.add(new JButton(String.valueOf(i)));			
			numberButtons.get(i).addActionListener(this);
			numberButtons.get(i).setFont(myFont);
			numberButtons.get(i).setFocusable(false);
		}
		
		negativeButton.setBounds(50, 430, 100, 50);
		deleteButton.setBounds(150, 430, 100, 50);
		clearButton.setBounds(250, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		panel.add(numberButtons.get(1));
		panel.add(numberButtons.get(2));
		panel.add(numberButtons.get(3));
		panel.add(additionButton);
		
		panel.add(numberButtons.get(4));
		panel.add(numberButtons.get(5));
		panel.add(numberButtons.get(6));
		panel.add(subtractButton);
		
		panel.add(numberButtons.get(7));
		panel.add(numberButtons.get(8));
		panel.add(numberButtons.get(9));
		panel.add(multiplicationButton);
		panel.add(decimalButton);
		
		panel.add(numberButtons.get(0));
		
		panel.add(equalsButton);
		panel.add(divisionButton);
		
		frame.add(panel);
		frame.add(negativeButton);
		frame.add(deleteButton);
		frame.add(clearButton);
		frame.add(textField);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		Calculator calculator = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i = 0; i < 10; i++)
		{
			if(e.getSource() == numberButtons.get(i))
			{
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decimalButton)
		{
			textField.setText(textField.getText().concat("."));
		}
		else if(e.getSource() == additionButton)
		{
			number1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		else if(e.getSource() == subtractButton)
		{
			number1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		else if(e.getSource() == multiplicationButton)
		{
			number1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		else if(e.getSource() == divisionButton)
		{
			number1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		else if(e.getSource() == equalsButton)
		{
			
			number2 = Double.parseDouble(textField.getText());
			
			switch(operator)
			{
			case '+':
				result = number1 + number2;
				break;
			case '-':
				result = number1 - number2;
				break;
			case '*':
				result = number1 * number2;
				break;
			case '/':
				result = number1 / number2;
				break;
			}
			textField.setText(String.valueOf(result));
			number1 = result;
		}
		else if(e.getSource() == clearButton)
		{
			textField.setText("");
		}
		else if(e.getSource() == deleteButton)
		{
			String deleteResult = textField.getText();
			textField.setText("");
			for(int i = 0; i < deleteResult.length() - 1; i++)
			{
				textField.setText(textField.getText() + deleteResult.charAt(i));
			}
		}
		else if(e.getSource() == negativeButton)
		{
			double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
	}

}
