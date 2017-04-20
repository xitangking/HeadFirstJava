package Chapter15;

import java.io.*;
import java.net.*;
import java.util.*;

public class VerySimpleChatServer
{
	ArrayList clientOutputStreams;
	
	public class ClientHandler implements Runnable
	{
		BufferedReader reader;
		Socket socket;
		
		public ClientHandler(Socket clientSocket)
		{
			try
			{
				socket = clientSocket;
				InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
				reader = new BufferedReader(inputStreamReader);
			} catch (Exception e)
			{
				// TODO: handle exception
			}
		}
		
		@Override
		public void run()
		{
			String message;
			try{
				while((message = reader.readLine()) != null)
				{
					System.out.println("read" + message);
					tellEveryone(message);
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		new VerySimpleChatServer().go();
	}
	
	public void go()
	{
		clientOutputStreams = new ArrayList();
		try
		{
			ServerSocket serverSocket = new ServerSocket(5000);
			
			while(true)
			{
				Socket clientSocket = serverSocket.accept();
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);
				
				Thread thread = new Thread(new ClientHandler(clientSocket));
				thread.start();
				System.out.println("got a connection");
			}
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	
	public void tellEveryone(String message)
	{
		Iterator iterator = clientOutputStreams.iterator();
		while(iterator.hasNext())
		{
			try
			{
				PrintWriter writer = (PrintWriter)iterator.next();
				writer.println(message);
				writer.flush();
			} catch (Exception e)
			{
				// TODO: handle exception
			}
		}
	}
}
