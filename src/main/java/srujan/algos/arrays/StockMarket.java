package srujan.algos.arrays;

public class StockMarket {
	
public int maxProfit(int[] prices) {
        
		    int leastBuy=0;
        int bestBuyTime=0;
        int bestSellTime=0;
        if(prices.length==0)
        	return 0;
        for (int i=0 ;i< prices.length;i++)
        {
        	if(prices[bestSellTime]-prices[bestBuyTime] <=prices[i]-prices[leastBuy])
        	{
        		bestSellTime=i;
        		bestBuyTime=leastBuy;
        	}
        	if(prices[leastBuy] >prices[i]) 
        	{
        		leastBuy=i;
        	}
        }
        return prices[bestSellTime]-prices[bestBuyTime];
    }

public int multiBuySell(int[] prices) {
    
    int buyTime=0;
    int sellTime=0;
    int curProfit=0;
    if(prices.length < 2)
    	return 0;
    int i=1;
   while(i< prices.length)
    {
    	if(prices[sellTime] <= prices[i])
        		sellTime = i; 
     	else 
    	{
    		curProfit = curProfit + prices[sellTime]-prices[buyTime];
    		buyTime=sellTime+1;
    		sellTime=buyTime;
    	}
    	i++;
    }
    return curProfit + prices[sellTime]-prices[buyTime]; 
}


public int twoBuySell(int[] prices) {
    
    int buyTime=0;
    int sellTime=0;
    int profit1=0;
    int profit2=0;
    if(prices.length < 2)
    	return 0;
    int i=1;
   while(i< prices.length)
    {
    	if(prices[sellTime] <= prices[i])
        		sellTime = i; 
     	else 
    	{
    		int curProfit = prices[sellTime]-prices[buyTime];
    		if(curProfit>profit1)
    		{
    			if(curProfit>profit2)
    			{
    				profit1=profit2;
    				profit2=curProfit;
    			}
    			else
    				profit1=curProfit;
    		}
    		buyTime=sellTime+1;
    		sellTime=buyTime;
    	}
    	i++;
    }
   int curProfit = prices[sellTime]-prices[buyTime];
   if(curProfit>profit1)return curProfit+profit2;
   else return profit1 +profit2 ; 
}

}
