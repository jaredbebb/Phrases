package words;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;


public class TextCorrelationTester {
	TextCorrelation testTextCorrelation = new TextCorrelation();
	
	String[] caseOne, caseTwo, caseThree, caseFour;
	@Before
	public void setUp() throws Exception{
		caseOne = new String[] {"snake", "turtle", "lizard"};
		caseTwo = new String[]{"wolf", "dog", "coyote"};
		caseThree =new String[] {"seagull", "hawk", "kite", "eagle"};
		caseFour = new String[] {"beatle", "moth"};
	}
	
	@Test
	public void testNumParse(){
		//assertEquals(null, testFiveConsecutiveNumbers.NumParse(caseOne));
		assertEquals(0, testTextCorrelation.lineCount(caseOne, "dog"));
		assertEquals(1, testTextCorrelation.lineCount(caseTwo, "dog"));
		assertEquals(0, testTextCorrelation.lineCount(caseThree, "dog"));
		assertEquals(0, testTextCorrelation.lineCount(caseFour, "dog"));
		assertEquals(0, testTextCorrelation.lineCount(caseFour, "dog"));
	}
	
}
