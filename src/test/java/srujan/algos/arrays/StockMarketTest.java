package srujan.algos.arrays;
import org.junit.Test;

import srujan.algos.arrays.StockMarket;


import org.junit.Assert;

public class StockMarketTest {
	
	@Test
	public void testStockMarket()
	{
		//int[] market = {7, 1, 5, 3, 6, 4};
		int[] market = {4,7,1,2,11};
		int[] market1 = {3,3,5,0,0,3,1,4};
		int[] market2 = {1,2,4,2,5,7,2,4,9,0};
		System.out.println(new StockMarket().maxProfit(market));
		System.out.println(new StockMarket().twoBuySell(market2));
		Assert.assertSame("blue is sky the","blue is sky the");
	}


}
