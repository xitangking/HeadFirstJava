package Chapter15;

import java.io.*;
import java.net.*;

public class DailyAdviceServer
{
	String[] adviceList = {
			"Take smaller bites",
			"Gofor the tight jeans.No they do NOT make you look fat.",
			"One word:inappropriate",
			"Just for today,be honest.Tell your boss what you *really* think",
			"You might want to rethink that haircut."
	};
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
	
	public void go()
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(4242);
			
			while(true)
			{
				Socket socket = serverSocket.accept();
				
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}
		} catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	private String getAdvice()
	{
		int random = (int)(Math.random() * adviceList.length);
		return adviceList[random];
	}

}
