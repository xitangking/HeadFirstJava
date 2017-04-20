package Chapter12;

import javax.swing.*;
import java.awt.event.*;

public class SimpleGuilB implements ActionListener
{

	JButton button;
	
	public static void main(String[] args)
	{
		SimpleGuilB guilB = new SimpleGuilB();
		guilB.go();
	}
	
	public  void go()
	{
		JFrame frame = new JFrame();
		button = new JButton("click me");
		
		button.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(button);
		
		frame.setSize(300, 300);
		
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		button.setText("I've been clicked!");
	}
}
