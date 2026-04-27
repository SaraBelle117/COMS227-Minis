package mini3;


import java.util.ArrayList;
import twenty_four_api.IntExpression;

/**
 * Sara Theriault
 * Com S 227 Fall 2023
 * Miniassignment 3
 * 
 * Implementation of a search for solutions to a number game inspired
 * by the game "twenty-four".
 */
public class TwentyFour
{
  /**
   * Lists all ways to obtain the given target number using arithmetic operations
   * on the values in the given IntExpression list.  Results in string form are added to 
   * the given result list, where the string form of a value is obtained from 
   * the toString() of the IntExpression object.
   * <p>
   * Special rules are: 
   * 1) you are not required to use all given numbers, and 
   * 2) division is integer division, and is only allowed when remainder is zero.  
   * For addition and multiplication, a + b and b + a are considered to be 
   * distinct solutions, and likewise a * b and b * a are considered as 
   * different solutions.  See the pdf for detailed examples.
   * @param list
   *   the values to be used in forming solutions
   * @param target
   *   the target number to be obtained from the values in the list
   * @param results
   *   list in which to place results, as strings
   */
  public static void findSolutions(ArrayList<IntExpression> list, int target, ArrayList<String> results)
  {
	 
    if(list.size() == 1) {
    	int baseCase = list.get(0).getIntValue();
    	if(baseCase == target) {
    		results.add(list.get(0).toString());
    	}
    }
    else {
    	for(int i = 0; i < list.size(); i++) {
    		ArrayList <IntExpression> listCopy = new ArrayList<>();
    		for(int j = 0; j < list.size(); j++) {
    			if(j != i) {
    				listCopy.add(list.get(j));
    			}
    			findSolutions(listCopy, target, results);
    		}
    	}
    	
    	
    }
  } 

}