package Chapter12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener
{
	JFrame frame;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		SimpleGui3C gui3c = new SimpleGui3C();
		gui3c.go();
	}
	
	public void go()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Change colors");
		button.addActionListener(this);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		frame.repaint();
	}

}
