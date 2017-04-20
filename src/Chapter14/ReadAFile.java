package Chapter14;

import java.io.*;

public class ReadAFile
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			File myFile = new File("MyText.txt");
			FileReader fileReader = new FileReader(myFile);
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line = null;
			
			while((line = reader.readLine()) != null)
				System.out.println(line);
			reader.close();
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		
	}

}
