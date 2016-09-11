package words;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FileHandling {
	

	
	HashMap<String, Integer> wordHash = new HashMap<String, Integer>();
	
	/*
	 * open file, which will be your input file
	 * Read in file, line by line, to conserve RAM
	 * Convert each line to lower case, remove punctuation
	 * Add phrases to hashmap
	 */
	HashMap<String, Integer> hashInputFile (File thisFile) throws IOException{
		String thisLine = null;
		FileReader fileToRead = new FileReader(thisFile);
		BufferedReader in = new BufferedReader(fileToRead);
		try {
	        while ((thisLine = in.readLine()) != null) {
	        	String[] thisLineArr = thisLine.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
	        	 oneWordPhrase(thisLineArr, wordHash);
	        	 twoWordPhrase(thisLineArr, wordHash);
	        	 threeWordPhrase(thisLineArr, wordHash);
	        }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
			in.close();
			} catch (IOException e){
				System.out.println("Cant close the file, "+thisFile.toString());
			}
		}
		return wordHash;
	}
	
	/*
	 * Add words to hashmap
	 * return hashmap
	 */
	public HashMap<String, Integer> oneWordPhrase(String [] Arr, HashMap<String, Integer> wordHashMap ){
    	String[] thisLineArr = Arr;
    	for(int word = 0; word < thisLineArr.length; word++) { 
    		Integer freq = wordHashMap.get(thisLineArr[word]); 
    		wordHashMap.put(thisLineArr[word], (freq == null) ? 1: freq + 1);
    	}
    	return wordHashMap;
	}
	
	public HashMap<String, Integer> twoWordPhrase(String [] Arr, HashMap<String, Integer> wordHashMap ){
		String[] thisLineArr = Arr;
    	for(int word = 0; word < thisLineArr.length-1; word++) { 
    		Integer freq = wordHashMap.get(thisLineArr[word]+" "+thisLineArr[word+1]); 
    		wordHashMap.put(thisLineArr[word]+" "+thisLineArr[word+1], (freq == null) ? 1: freq + 1);
    	}
		return wordHashMap;
	}
	
	public HashMap<String, Integer> threeWordPhrase(String [] Arr, HashMap<String, Integer> wordHashMap ){
		String[] thisLineArr = Arr;
    	for(int word = 0; word < thisLineArr.length-2; word++) { 
    		Integer freq = wordHashMap.get(thisLineArr[word]+" "+thisLineArr[word+1]+" "+thisLineArr[word+2]); 
    		wordHashMap.put(thisLineArr[word]+" "+thisLineArr[word+1]+" "+thisLineArr[word+2], (freq == null) ? 1: freq + 1);
    	}
		return wordHashMap;
	}
	
	/*
	 * open file, which will be your outputfile
	 * formattted as xml
	 * each Key, Value pair in hashmap printed as xml entry
	 */
	public void hashToOut(String inputFilePath, String outputFilePath) throws IOException{
		File fileOut = new File(outputFilePath);
		FileWriter fileWriterOut = new FileWriter(fileOut);
		BufferedWriter out = new BufferedWriter(fileWriterOut);
		File input = new File(inputFilePath);
		Set set = hashInputFile(input).entrySet();
		Iterator i = set.iterator();
		out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.newLine();
		while(i.hasNext()){
			Map.Entry me = (Map.Entry)i.next();
			out.write("<entry>");
			out.newLine();
			out.write("<phrase>"+me.getKey()+"</phrase>");
			out.write("<count>"+me.getValue()+"</count>");
			out.newLine();
			out.write("</entry>");
			out.newLine();
		}
		out.close();
	}
	
	public static void main (String[] args ) throws IOException{
		FileHandling test = new FileHandling();
		test.hashToOut("C:\\inputfile directory...","C:\\outputfile directory");
	}
}


