package Chapter5;

/**
 * Created by xtw on 2017/1/26.
 */
public class SimpleDotComTestDrive
{
    public static void main(String[] args)
    {
    	SimpleDotCom dotCom = new SimpleDotCom();
    	int[] locations = {2,3,4};
    	dotCom.setLoactionCells(locations);
    	
    	String userGuess = "3";
    	String result = dotCom.checkYourself(userGuess);
    	String testResult = "failed";
    	if(result.equals("hit"))
    		testResult = "passed";
    	System.out.println(testResult);
    }


}
