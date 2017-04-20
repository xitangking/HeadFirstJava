package Chapter13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextArea1 implements ActionListener
{
	JTextArea textArea;
	public static void main(String[] args)
	{
		TextArea1 gui = new TextArea1();
		gui.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Just Click It");
		button.addActionListener(this);
		textArea = new JTextArea(10,20);
		textArea.setLineWrap(true);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.add(scrollPane);
		
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.setSize(350,300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		textArea.append("button clicked \n");
	}
}
