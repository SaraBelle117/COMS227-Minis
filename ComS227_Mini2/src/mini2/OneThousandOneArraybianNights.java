package mini2;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Sara Theriault
 * Com S 227
 * Mini Assignment 2
 *
 */
public class OneThousandOneArraybianNights{
	
private OneThousandOneArraybianNights(){
// disable instantiation
}

public static void main(String[] args) {
	
}

/**
* Returns the first index i in arr for which either the element at i is zero,
* or the element is equal to the one on its right.
* If no such index exists, the method returns -1. For example,
* <ul>
* <li>given [5, 4, 0, 3, 3, 6], returns 2
* <li>given [5, 3, 3, 0, 2], returns 1
* <li>given [5, 3, 2, 1, 2], returns -1
* </ul>
*
* @param arr
* given array
* @return
* first index of a zero or pair of matching values
*/
public static int findIt(int[] arr){
	
	for(int i = 0; i < arr.length; i++) {
		if(arr[i] == 0) {
			return i;
		}
		else {
			if(i != arr.length - 1) {
				if(arr[i] == arr[i + 1]) {
					return i;
				}
			}
		}
	}
	return -1;
}
/**
* Returns a new array similar to the given array, but with duplicate
* elements removed. The relative ordering
* of the first occurrence of each element is unchanged. The given array
* is not modified. The method is case sensitive.
* <p>
* <em>Example: </em>Given the array ["Eel", "Aardvark", "Eel", "Dog", "Eel",
"Aardvark", "Helicopter", "Dog"],
* returns the array ["Eel", "Aardvark", "Dog", "Helicopter"].
* @param arr
* given array
* @return
* new array with duplicates removed
*/
public static String[] removeMultiples(String[] arr){
	String[] result = new String[arr.length];
	String toAdd;
	boolean matchFound;
	int arraySize = 0;
	
	for(int i = 0; i < arr.length; i++) {
		matchFound = false;
		toAdd = "";
		toAdd = arr[i];
		for(int j = 0; j < result.length; j++) {
			if(arr[i].equals(result[j])) {
				matchFound = true;
			}
		}
		if(!matchFound) {
			result[i] = toAdd;
			arraySize++;
		}
	}
	//new array without null index values
	String[] multiplesRemoved = new String[arraySize];
	int j = 0;
		for(int i = 0; i < result.length; i++) {
			if(result[i] != null) {
				multiplesRemoved[j] = result[i];
				j++;
			}
		} 
	return multiplesRemoved;
}

/**
* Creates a new array from the given one by adding up groups
* of k adjacent entries. The length of the returned array
* is always <code>arr.length / k</code> (integer division),
* and its ith element is the sum
* <p>
* arr[ik] + arr[ik + 1] + arr[ik + 2] + ... + arr[ik + (k - 1)]
* <p>
* If the array length is not an exact multiple
* of k, the excess elements are ignored. For example, if
* arr is [1, 2, 3, 4, 5, 6, 7] and k is 3, the
* result is [6, 15].
* @param arr
* any int array
* @param k
* number of adjacent elements in each group
* @return
* new array obtained by adding up groups of adjacent elements
*/
public static int[] condense(int[] arr, int k){
	int[] result = new int[(arr.length)/k];
	int sum;
	for(int i = 0; i < result.length; i++) {
		sum = 0;
		for(int j = 0; j < k; j++) {
			sum += arr[i * k + j];
		}
		result[i] = sum;
	}
	return result;
}
/**
* Rearrange the elements of arr according to the given list of
* indices. After calling this method, arr[i] should contain
* the value formerly located at arr[swizzler[i]].
* For example, if swizzler is [3, 0, 3, 1] and arr is
* <pre>
* [10, 20, 30, 40]
* </pre>
* and
* then after this method executes, arr is
* <pre>
* [40, 10, 40, 20].
* </pre>
* If the swizzler length
* does not match the array length, or if it contains any
* number that is out of range as an index in arr,
* the method does nothing. Note that this method
* modifies the given array and returns void.
* @param arr
* the int array to be modified
* @param swizzler
* array of indices indicating new positions of elements
*/
public static void swizzle(int[] arr, int[] swizzler){
	int[] temp = new int[arr.length];
	if(arr.length == swizzler.length) {
		for(int i = 0; i < arr.length; i++) {
			if(swizzler[i] >= 0 && swizzler[i] < arr.length) {
				temp[i] = arr[swizzler[i]];
			}
			else {
				return;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];
		}
		
	}
	else {
		return;
	}
}
/**
* Given an array arr, returns a new array of indices that identify
* the elements of the array in ascending order. For example, given array
* [12, 7, 4, 5, 8], the method returns [2, 3, 1, 4, 0], since<br>
* [arr[2], arr[3], arr[1], arr[4], arr[0]]<br>
* gives the elements of arr in ascending order. Note also that
* executing code such as this for an array 'test':
* <pre>
* int[] swizzler = findSwizzlerThatSorts(test);
* swizzle(test, swizzler);
* </pre>
* will cause 'test' to be sorted.
* <p>
* You can assume that none of the values is equal to Integer.MAX_VALUE.
<strong>The given
* array should not be modified.</strong>
* @param arr
* given array
* @return
* array of indices that select elements in ascending order
*/
public static int[] findSwizzlerThatSorts(int[] arr){
	int[] sortedIndices = new int[arr.length];
	//keeping track of matches values
	boolean[] isMatched = new boolean[arr.length]; 
	int[] sortedArray = new int[arr.length];
	//guiding point for index order
	System.arraycopy(arr, 0, sortedArray, 0, arr.length);
	Arrays.sort(sortedArray);
	
	for(int i = 0; i < arr.length; i++) {
		for(int j = 0; j < arr.length; j++) {
			if(sortedArray[i] == arr[j] && isMatched[j] == false) {
				sortedIndices[i] = j;
				isMatched[j] = true;
				break;
			}
		}
	}
		
	return sortedIndices;
	}
/**
* Finds array t as a subsequence of arr and returns a list of the indices
* where each element of t was first found. For example, given the
* array
* <p>
* arr = [65, 42, 137, 12, 42, 42, 17, 8, 99]
* <p>
* and t = [137, 42, 8]
* <p>
* the method should return the array of indices [2, 4, 7].
* <p>
* If t is not a subsequence of arr, the method returns an empty array.
* @param arr
* source array
* @param t
* target array to find in arr
* @return
* list of indices where t was found, or an empty list
*/
public static int[] findSubsequence(int[] arr, int[] t){
	ArrayList<Integer> indicesOfT = new ArrayList<Integer>();
	int currentT = 0;
	for(int i = 0; i < arr.length; i++) {
			if(currentT == t.length) {
				break;
			}
			if(arr[i] == t[currentT]) {
				indicesOfT.add(i);
				currentT++;
			}
		}
	int arraySize = indicesOfT.size();
	//only converts from array list to array if end of T was reached
	if(currentT == t.length) {
		int[] convertedArray = new int[arraySize];
		for(int i = 0; i < arraySize; i++) {
			convertedArray[i] = indicesOfT.get(i);
		}
		return convertedArray;
	}
	else {
		//returns empty string if no subsequence of t
		return new int[0];
	}
}


}