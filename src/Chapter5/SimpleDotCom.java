package Chapter5;

/**
 * Created by xtw on 2017/1/26.
 */
public class SimpleDotCom
{
	private int[] locationCells = new int[3];
	private int numOfHit = 0;
    public void setLoactionCells(int[] array)
    {
    	for(int i = 0;i < array.length;++i)
    		locationCells[i] = array[i];
    }

    public String checkYourself(String stringGuess)
    {
    	int guess = Integer.parseInt(stringGuess);
    	String result = "miss";
    	
    	for(int i = 0;i < locationCells.length;++i)
    	{
    		if(guess == locationCells[i])
    		{
    			result = "hit";
    			locationCells[i] = -1;
    			++numOfHit;
    			break;
    		}
    	}
    	if(numOfHit == locationCells.length)
    		result = "kill";
    	System.out.println(result);
        return result;
    }
    
    public static void main(String[] args)
	{
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		
		SimpleDotCom theDotCom = new SimpleDotCom();
		int randomNum = (int)(Math.random() * 5);
		
		int[] locations = {randomNum,randomNum + 1,randomNum + 2};
		theDotCom.setLoactionCells(locations);
		boolean isAlive = true;
		
		while(isAlive == true)
		{
			String guess = helper.getUserInput("enter a number ");
			String result = theDotCom.checkYourself(guess);
			++numOfGuesses;
			if(result.equals("kill"))
			{
				isAlive = false;
				System.out.println( "You took " + numOfGuesses + " guesses");
			}
		}
	}

}
