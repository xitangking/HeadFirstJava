package Chapter10;

import static java.lang.System.out;
import java.util.*;

public class FullMooms
{
	static int DAY_TM = 1000 * 60 * 60 * 24;
	public static void main(String[] args)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(2004, 0,7,15,40);
		long day1 = calendar.getTimeInMillis();
		for(int x = 0;x < 60;++x)
		{
			day1 += (DAY_TM * 29.52);
			calendar.setTimeInMillis(day1);
			out.println(String.format("full moon on %tc", calendar));
		}
	}
}
