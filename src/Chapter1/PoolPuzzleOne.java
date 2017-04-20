/******************************************************************************************
* Head First Java -- ”æ≥ÿ√‘π¨1
* ±˚…Í∫ÔƒÍ¿∞‘¬ÿ•∞À 2017/1/25 21£∫40
* @author Œ˜Ã∆Õı, xtwyzh@gmail.com, xtwroot.com
* xtwroot Copyright (c) 2017. All rights reserved.
******************************************************************************************/

package Chapter1;

public class PoolPuzzleOne
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int x = 0;
		while(x < 4)
		{
			System.out.print("a");
			if(x < 1)
				System.out.print(" ");
			System.out.print("n");
			if(x > 1)
			{
				System.out.print(" oyster");
				x = x + 2;
			}
			if(x == 1)
				System.out.print("noys");
			if(x < 1)
				System.out.print("oise");
			System.out.println("");
			x = x + 1;
		}
	}
}
