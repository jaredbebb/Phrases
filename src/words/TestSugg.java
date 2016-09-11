package words;

import java.util.HashMap;

public class TestSugg {
	
	//file testFile = new fileinputreader();
	
	
	public static void PhaseAdd(String sent, int phraseLength){
		
		
		HashMap<String, Integer> HM = new HashMap<String, Integer>();
		String[] sentLowSplit = sent.toLowerCase().split(" ");
		
		int w = 1;
		while(w <= phraseLength){
		
		switch(w){
		case 1:for(int i = 0; i < sentLowSplit.length - phraseLength; i ++)
			{
				String phrase= sentLowSplit[i];
				System.out.println(phrase);
				Integer freq = HM.get(phrase);
				HM.put(phrase, (freq == null) ? 1: freq + 1);
				

			}
		break;
		case 2: for(int i = 0; i < sentLowSplit.length - (phraseLength+1); i ++)
		{
			String phrase= sentLowSplit[i] + " " + sentLowSplit[i+1];
			System.out.println(phrase);
			Integer freq = HM.get(phrase);
			HM.put(phrase, (freq == null) ? 1: freq + 1);

		}
		break;
		case 3:for(int i = 0; i < sentLowSplit.length - (phraseLength+2); i ++)
		{
			String phrase= sentLowSplit[i] + " " + sentLowSplit[i+1] + " "+ sentLowSplit[i+2];
			System.out.println(phrase);
			Integer freq = HM.get(phrase);
			HM.put(phrase, (freq == null) ? 1: freq + 1);
		}
		case 4:for(int i = 0; i < sentLowSplit.length - (phraseLength+3); i ++)
		{
			String phrase= sentLowSplit[i] + " " + sentLowSplit[i+1] + " "+ sentLowSplit[i+2] + " " + sentLowSplit[i+3];
			System.out.println(phrase);
			Integer freq = HM.get(phrase);
			HM.put(phrase, (freq == null) ? 1: freq + 1);
		}
		}
		w++;
		}
		System.out.println( HM);
		
	}
	

	public static void main(String[] args) {
		String test = "My Schedule E line 2 is not correct on my return. schedule E line 2 must be resolved quick. I better get my taxes done soon. schedule e line 3 is wrong too";
		PhaseAdd(test, 4);

	}

}
