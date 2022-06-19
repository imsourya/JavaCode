package duega.algo.codeBlock;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {

	private static void printAllSubsets(String[] list, int indx, List<String> resultant, String result) {
		
		if(indx == list.length) {
			resultant.add(result);
			return;
		}
		
		// Selected
		printAllSubsets(list, indx+1, resultant, result+list[indx]);
		
		// non selected
		printAllSubsets(list, indx+1, resultant, result);
	}
	
	public static void main(String[] args) {
		String [] lists = {"ab", "cd", "ab"};
		List<String> resultant = new ArrayList<String>(); 
		printAllSubsets(lists, 0, resultant, "");
		
		for(String str : resultant)
		{
			System.out.println(str);
		}
		System.out.println(resultant.size());
	}
}
