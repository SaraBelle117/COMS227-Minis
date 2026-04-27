
package mini3;

import maze_api.CellStatus;
import maze_api.MazeCell;
import maze_api.TwoDMaze;
import maze_ui.MazePanel;
import maze_api.CellStatus.*;


/**
 * Sara Theriault
 * Com S 227 Fall 2023
 * Miniassignment 3
 * 
 * 
 * Utility class for searching a maze described by a collection
 * of MazeCell objects.
 */
public class MazeExplorer
{
  //private static final CellStatus FOUND_IT = null;

/**
   * Recursively searches a given MazeCell and all of its unexplored 
   * neighbors.  Immediately returns true if the current cell is the goal;
   * otherwise,  immediately returns false if the current cell is a wall 
   * or if the current cell's status is anything other than NOT_STARTED.
   * Otherwise, initiates a recursive search of the neighbors of the current cell.
   * If any search of a neighbor results in the goal being found, the current cell's status
   * is set to CellStatus.FOUND_IT and the method immediately returns true.  If 
   * no search of a neighbor results in the goal being found, the current cell's 
   * status is set to DEAD_END and the method returns false.
   * <p>
   * <strong>Neighbors are always searched in the order up, down, left, then right,</strong>
   * and during a recursive search of a neighbor, the current cell's status
   * is set to SEARCHING_UP, SEARCHING_DOWN, SEARCHING_LEFT, or SEARCHING_RIGHT, 
   * respectively.
   * 
   * @param maze
   *   the 2d grid to be searched
   * @param row
   *   the row for the current cell being searched
   * @param col
   *   the column for the current cell being searched
   * @return
   *   true if a search from the current cell has reached the goal,
   *   false if the goal can't be reached from the current cell
   */
  public static boolean search(TwoDMaze maze, int row, int col)
  {
	  MazeCell check = maze.getCell(row, col);
      CellStatus stat = check.getStatus(); 
      
      if(check.isGoal()) {
    	  return true;
      }
      else if(check.isWall()|| stat != CellStatus.NOT_STARTED) {
    	  return false;
      }
      else{
    	  check.setStatus(CellStatus.SEARCHING_UP);
    	  if(search(maze, row - 1, col)) {
    		  check.setStatus(CellStatus.FOUND_IT);
    		  return true;
    	  }
    	  
    	  check.setStatus(CellStatus.SEARCHING_DOWN);
    	  if(search(maze, row + 1, col)) {
    		  check.setStatus(CellStatus.FOUND_IT);
    		  return true;
    	  }
    	  
    	  check.setStatus(CellStatus.SEARCHING_LEFT);
    	  if(search(maze, row, col - 1)) {
    		  check.setStatus(CellStatus.FOUND_IT);
    		  return true;
    	  }

    	  check.setStatus(CellStatus.SEARCHING_RIGHT);
    	  if(search(maze, row, col + 1)) {
    		  check.setStatus(CellStatus.FOUND_IT);
    		  return true;
    	  }
   
    	  else {
    		  check.setStatus(CellStatus.DEAD_END);
    		  return false;
    	  }
      }
      
      
     // return false;
  }
}

/*
 * 
 * to search a maze starting from cell c:
if c is the goal
return true (success)
else if c isn't an unexplored cell (i.e. it's a wall, or been there already)
return false
else
for each neighboring cell d (in the order up, down, left, right)
mark cell c to record the direction of d
recursively search the maze starting from d
if the search returns true
mark cell c as found and return true
//if we fall through to this point after searching all four directions...
mark cell c as a dead end and return false

 * Base case:
 * if curr[row][col] == goal
 * return true; 
 * 
 * else{
 * - search the maze until we find the goal
 * mark each searched sell as searched (or appropriate CellStatus)
 *
 *}
 */
