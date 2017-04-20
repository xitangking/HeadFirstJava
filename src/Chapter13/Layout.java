package Chapter13;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class Layout
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Layout layout = new Layout();
		layout.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JButton button = new JButton("shock me");
		JButton buttonTwo = new JButton("bliss");
		panel.add(button);
		panel.add(buttonTwo);
		frame.getContentPane().add(BorderLayout.EAST, panel);
		frame.setSize(250,250);
		frame.setVisible(true);
	}

}
