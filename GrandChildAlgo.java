package CareerCup;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given a two dimensional array of string like
 * <"luke", "shaw">
 * <"wayne", "rooney">
 * <"rooney", "ronaldo">
 * <"shaw", "rooney">
 * 
 * where the first string is "child" second string is "father".
 * And given "ronaldo" we have to find his no of grandchildren. Here
 * "ronaldo" has 2 grand children. So our output should be 2.
 */
public class GrandChildAlgo {
	HashMap<String, ArrayList<String>> fatherSonMap = new HashMap<>();
	
	public void constructFatherSonMap(String[][] famArray) {
		for(int i = 0; i < famArray.length; i++) {
			String father = famArray[i][1];
			father = father.trim();
			
			if(fatherSonMap.containsKey(father)) {
				ArrayList<String> sonLst = fatherSonMap.get(father);
				sonLst.add(famArray[i][0]);
				
			} else {
				ArrayList<String> sonList = new ArrayList<String>();
				sonList.add(famArray[i][0]);
				fatherSonMap.put(father, sonList);
			}
		}
		
		System.out.println(fatherSonMap);
	}
	
	public void getGrandChildren( String gpName) {
		ArrayList<String> gChildren = new ArrayList<>();
		if (fatherSonMap.isEmpty()) {
			System.out.println("Map is empty");
			return;
		}
		
		ArrayList<String> children = fatherSonMap.get(gpName);
		for(String child : children) {
			gChildren.addAll(fatherSonMap.get(child));
		}
		System.out.println(gChildren);
	}

	public static void main(String[] args) {

		String[][] familyArray = { 
				{"luke", "shaw"}, {"wayne", "rooney"}, {"rooney", "ronaldo"}, {"shaw", "rooney"}
				};
		
		GrandChildAlgo gcObj = new GrandChildAlgo();
		gcObj.constructFatherSonMap(familyArray);
		gcObj.getGrandChildren("ronaldo");
	}
}
