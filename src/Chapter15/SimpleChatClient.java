package Chapter15;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClient
{
	JTextArea incoming;
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	
	public static void main(String[] args)
	{
		SimpleChatClient client = new SimpleChatClient();
		client.go();
	}
	
	public void go()
	{
		JFrame frame = new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel = new JPanel();
		incoming = new JTextArea(15,50);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		JScrollPane qScrollPane = new JScrollPane(incoming);
		qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(qScrollPane);
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		setUpNetworking();
		
		Thread readerThread = new Thread(new IncomingReader());
		readerThread.start();
		
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 400);
		frame.setVisible(true);
	} // go end
	
	private void setUpNetworking()
	{
		try
		{
			sock = new Socket("127.0.0.1", 5000);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("networking established");
		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
	} // setUpNetworking end
	
	public class SendButtonListener implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				writer.println(outgoing.getText());
				writer.flush();
			} catch (Exception e2)
			{
				// TODO: handle exception
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	} // SendButtonListener end
	
	public class IncomingReader implements Runnable

	{
		@Override
		public void run()
		{
			String message;
			try
			{
				while((message = reader.readLine()) != null)
				{
					System.out.println("read" + message);
					incoming.append(message + "\n");
				}
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	} // IncomingReader end
	
	
}
