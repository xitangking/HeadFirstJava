package Chapter14;

import java.io.*;

public class WriteAFile
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		try
		{
			FileWriter writer = new FileWriter("Foo.txt");
			writer.write("hello foo!");
			writer.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
