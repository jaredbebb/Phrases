package words;

import java.util.HashMap;

public class WordsNear {

	
	public static void StringHash(String[] locString)
	{
		HashMap<String, Integer> HM = new HashMap<String, Integer>();
		for(String word : locString)
		{
			Integer freq = HM.get(word);
			HM.put(word, (freq == null) ? 1: freq + 1);
		}
		System.out.println("There are "+HM.size() + " distinct words:");
        System.out.println(HM);
	}
	
	public static void main(String[] args)
	{
		String words = "Hi my name is myname I'm not sure why my name has both my and name in it Oh well";
		String[] wordsToArr = words.split(" ");
		StringHash(wordsToArr);
	}

}
