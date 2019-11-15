package srujan.algos.strings;

import org.junit.Test;

import srujan.algos.strings.GenericStringAlgos;

import org.junit.Assert; 

public class GenericStringAlgosTest {
	
	@Test
	public void testReverseWords()
	{
		Assert.assertSame(new GenericStringAlgos().reverseWords(" 1"),"1");
		Assert.assertSame("blue is sky the","blue is sky the");
	}

}
