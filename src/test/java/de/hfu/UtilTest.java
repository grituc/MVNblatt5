package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
	@Test
	public void testUtil_istErstesHalbjahr(){
		Util u = new Util();  //don't need it, the method to test is static. Update: DO need it in order to test constructor
		final boolean expectedValue = true; //don't need either, may use assertTrue and assertFalse instead
		assertEquals(expectedValue, Util.istErstesHalbjahr(5));
		assertTrue(Util.istErstesHalbjahr(1));
		assertFalse(Util.istErstesHalbjahr(8));
		//Check border-values
		assertTrue(Util.istErstesHalbjahr(1));
		assertFalse(Util.istErstesHalbjahr(12));
		assertTrue(Util.istErstesHalbjahr(6));
		assertFalse(Util.istErstesHalbjahr(7));
		//Util.istErstesHalbjahr(13); //error: IllegalArgumentException

				
	}
	//now testing exceptions
	
	@Test(expected = IllegalArgumentException.class)
	public void test2Util_istErstesHalbjahr(){
		Util.istErstesHalbjahr(13);
		Util.istErstesHalbjahr(11); //no exception here, still ok for the test, since there is one exception 
									//for the example above

	}

	@Test(expected = IllegalArgumentException.class)
	public void test3Util_istErstesHalbjahr(){
		Util.istErstesHalbjahr(0);
	}



}
