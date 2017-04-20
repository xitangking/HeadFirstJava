/******************************************************************************************
* Head First Java -- 专家术语生成
* 丙申猴年腊月廿八 2017/1/25 21:00
* @author 西唐王, xtwyzh@gmail.com, xtwroot.com
* xtwroot Copyright (c) 2017. All rights reserved.
******************************************************************************************/

package Chapter1;

public class PhraseOMatic
{

	public static void main(String[] args)
	{
		String[] wordListOne  = {"24/7","multiTier","30,000 foot","B-to-B",
				"win-win","front-end","wed-based","pervasive","smart","sixsigma",
				"critical-path","dynamic"};
		String[] wordListTwo = {"empowered", "sticky",
				"value-added", "oriented", "centric", "distributed",
				"clustered", "branded","outside-the-box", "positioned",
				"networked", "focused", "leveraged", "aligned",
				"targeted", "shared", "cooperative", "accelerated"};
		String[] wordListThree = {"process", "tippingpoint", "solution",
				"architecture", "core competency",
				"strategy", "mindshare", "portal", "space", "vision",
				"paradigm", "mission"};
		//
		int oneLength = wordListOne.length;
		int twoLength  = wordListTwo.length;
		int threeLength = wordListThree.length;
		//
		int rand1 = (int)(Math.random() * oneLength);
		int rand2 = (int)(Math.random() * twoLength);
		int rand3 = (int)(Math.random() * threeLength);
		//
		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + 
				" " + wordListThree[rand3];
		System.out.println( "What we need is a " + phrase);
	}
}


