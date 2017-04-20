package Chapter14;

import java.io.*;

public class GameSaverTest
{

	public static void main(String[] args)
	{
		GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow","sword","dust"});
		GameCharacter two = new GameCharacter(200, "Troll", new String[] {"bow","sword","dust"});
		GameCharacter three = new GameCharacter(120, "Magician", new String[] {"bow","sword","dust"});
		
		try
		{
			ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream("Game.ser"));
			oStream.writeObject(one);
			oStream.writeObject(two);
			oStream.writeObject(three);
			oStream.close();
		} 
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		one = two = three = null;
		
		try
		{
			@SuppressWarnings("resource")
			ObjectInputStream iStream = new ObjectInputStream(new FileInputStream("Game.ser"));
			
			one = (GameCharacter) iStream.readObject();
			two = (GameCharacter) iStream.readObject();
			three = (GameCharacter) iStream.readObject();
			
			System.out.println(one.getType());
			System.out.println(two.getType());
			System.out.println(three.getType());
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
