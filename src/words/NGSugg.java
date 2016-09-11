package words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class NGSugg {

public HashMap<String, Integer>hm;
	
	
	/*
	 * Add words from string/file to hashmap
	 * if word isn't in hashmap, add it
	 * else, add +1 to that words count
	 * 
	 * also, include list of nearby words to list<String>
	 */
	public static  HashMap<String, Integer> StringHash(String[] locString) 
	 	{ 
			HashMap<String, Integer> HM = new HashMap<String, Integer>();
			List<String> queue = new LinkedList<String>();
			
			
	 		for(String word : locString) 
	 		{ 
	 			Integer freq = HM.get(word); 
	 			HM.put(word, (freq == null) ? 1: freq + 1);


	 		} 
	 		//System.out.println("There are "+HM.size() + " distinct words:"); 
	        //System.out.println(HM);
	        
	        return HM;
	 	}
	
	  
	private static List<String> generateNgrams(int N, String sent, List<String> ngramList) {
		HashMap<String, Integer> HM = new HashMap<String, Integer>();
	  String[] tokens = sent.split("\\s+"); //split sentence into tokens
	 
	  //GENERATE THE N-GRAMS
	  for(int k=0; k<(tokens.length-N+1); k++){
	    String s="";
	    int start=k;
	    int end=k+N;
	    for(int j=start; j<end; j++){
	     s=s+" "+tokens[j];
	     for(String m: tokens){
	    	 
	     }
	    }
	    //Add n-gram to a list
	    ngramList.add(s);
	  }
	  return ngramList;
	}//End of method
	

	static String simpleSentence = "The brown cow jumped over the moon. The gray cow jumped over a bucket. The white cow jumped to conclusions";
	static List<String> newLS = new ArrayList<String>();
	
	
	



	
	public static void main(String[] args){
		String words = "Hi my name is myname I'm not sure why my name has both my and name in it Oh well";
		String[] wordsToArr = words.split(" ");
		System.out.println(StringHash(wordsToArr));
		System.out.println(generateNgrams(2, simpleSentence, newLS));
		
		
	}
}
