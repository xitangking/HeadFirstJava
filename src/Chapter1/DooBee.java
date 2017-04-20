/******************************************************************************************
* Head First Java -- print and println
* ?????????????? 2017/1/25 20:44
* @author ??????, xtwyzh@gmail.com, xtwroot.com
* xtwroot Copyright (c) 2017. All rights reserved.
******************************************************************************************/

package Chapter1;

public class DooBee
{

	public static void main(String[] args)
	{
		int i = 2;
		while (i < 3)	
		{
			System.out.print("Doo");
			System.out.print("Bee");
			++i;
		}
		if(i == 3)
			System.out.print("Do");
	}

}
