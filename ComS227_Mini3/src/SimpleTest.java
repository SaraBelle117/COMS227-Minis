import java.util.ArrayList;
import java.util.Collections;

import mini3.TwentyFour;
import twenty_four_api.IntExpression;

public class SimpleTest
{

  public static void main(String[] args)
  {
    IntExpression v1 = new IntExpression(2);
    IntExpression v2 = new IntExpression(3);
    System.out.println(v1.toString()); // prints "2" 
    System.out.println(v2.toString()); // prints "3" 
    IntExpression v3 = new IntExpression(v1, v2, '+'); 
    System.out.println(v3.toString()); // prints "(2 + 3)" 
    System.out.println(v3.getIntValue()); // 5
    IntExpression v4 = new IntExpression(v2, v3, '*');
    System.out.println(v4.toString()); // prints "(3 * (2 + 3))"
    System.out.println();
    
    int[] values = { 2, 3, 3, 5 };
    ArrayList<IntExpression> expressions = new ArrayList<IntExpression>();
    for (int x : values)
    {
      expressions.add(new IntExpression(x));
    }
    ArrayList<String> results = new ArrayList<String>(); // empty list 
    TwentyFour.findSolutions(expressions, 11, results);
    System.out.println(results);
    
    ArrayList<String> uniqueResults = new ArrayList<String>();
    for (String r : results)
    {
      if (!uniqueResults.contains(r))
      {
        uniqueResults.add(r);
      }
    }
    Collections.sort(uniqueResults);
    for (String r : uniqueResults)
    {
      System.out.println(r);
    }

    
  }

}
