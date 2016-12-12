package words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TextCorrelation {
	
	public static HashMap<String, Integer> Correlation(String[] InputArr, String Match){
		ArrayList<String> Input = new ArrayList<String>(Arrays.asList(InputArr));
		ArrayList<String> found = new ArrayList<String>();
		HashMap<String, Integer> corres = new HashMap<String, Integer>();
		
		if(Input.contains(Match)){
			for(int i = 0; i < Input.size(); i++){
				String pos = Input.get(i);
				if(!found.contains(pos)){
					found.add(pos);
					Integer freq = corres.get(pos);
					corres.put(pos, (freq == null) ? 1: freq + 1);
					System.out.println("added this to list: "+pos);
				}
			}
		}
		return corres;
	}
	//helper method to see if array has a match, if it does, returns 1
	public int lineCount(String[] InputArr, String Match){
		int count = 0;
		ArrayList<String> Input = new ArrayList<String>(Arrays.asList(InputArr));
		Input = new ArrayList<String>(Arrays.asList(InputArr));
		if(Input.contains(Match)){
			count = 1;
		}
		return count;
	}
}
