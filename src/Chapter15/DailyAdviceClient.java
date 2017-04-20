package Chapter15;

import java.io.*;
import java.net.*;

public class DailyAdviceClient
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}
	
	public void go()
	{
		try
		{
			@SuppressWarnings("resource")
			Socket socket = new Socket("127.0.0.1", 4242);
			
			InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
			
			String advice = reader.readLine();
			System.out.println("Today you should:" + advice);
			
			reader.close();
		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
	}
	
}
