/******************************************************************************************
* Head First Java -- 
* ±ûÉêºïÄêÀ°ÔÂØ¥°Ë 2017/1/25 20:46
* @author Î÷ÌÆÍõ, xtwyzh@gmail.com, xtwroot.com
* xtwroot Copyright (c) 2017. All rights reserved.
******************************************************************************************/

package Chapter1;

import java.beans.beancontext.BeanContextMembershipEvent;

public class BeerSong
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int beerNum = 99;
		String word = "bottles";
		
		while(beerNum > 0)
		{
			if(beerNum == 1)
				word = "bottle";
			System.out.println(beerNum + " " + word + " if beer on the wall");
			System.out.println(beerNum + " " + word + " of beer.");
			System.out.println( "Take one down." );
			System.out.println( "Pass it around." );
			beerNum--;
			if (beerNum > 0)
				System.out.println(beerNum + " " + word + " of beer on the wall");
			else
				System.out.println( "No more bottles of beer on the wall" );
		}
	}

}
