package CareerCup;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Alternate sorting: Given an array of integers, rearrange the array in such a 
 * way that the first element is first maximum and second element is first minimum
 * eg: 	Input : {1, 2, 3, 4, 5, 6, 7}
 * 		Output: {7, 1, 6, 2, 5, 3, 4} 
 */
public class AlternateSorting {

	public static void altSorting(ArrayList<Integer> intList) {
		ArrayList<Integer> altIntList = new ArrayList<Integer>();
		Collections.sort(intList);
		int sz = intList.size();
		int lastInx = sz - 1;
		int inx = 0;
		while(inx < (sz/2)) {
			altIntList.add(intList.get(lastInx));
			altIntList.add(intList.get(inx));
			inx++;
			lastInx--;
		}
		if (inx == lastInx ) {
			altIntList.add(intList.get(inx));
		}
		System.out.println(altIntList);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		intList.add(6);
		intList.add(7);
		
		AlternateSorting.altSorting(intList);
	}

}
