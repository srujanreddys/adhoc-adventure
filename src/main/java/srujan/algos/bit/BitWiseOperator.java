package srujan.algos.bit;

public class BitWiseOperator {
	
	  public int reverseBits( int n) {
	        int i =0;
	        StringBuilder sb = new StringBuilder();
	        System.out.println(Integer.toBinaryString(n));
	        int result =0;
		  while(i<32){
			 sb.append(Integer.toBinaryString(n&1));
			 result =result + (n&1);
		     n = n>>>1;
		     if (i < 31) 
		    	 result=result <<1;
		    i++;
		  }
		  System.out.println(Integer.toBinaryString(result));
		  System.out.println(sb);
		  return result;
	

	    }
	  public int hammingWeight(int n) {
	        
		  int i =0;
	        int result =0;
		  while(i<32){
			 result =result + (n&1);
		     n = n>>>1;
		    i++;
		  }
		  return result;
	        
	    }
	  
	  public void addTwoNumbers(int a ,int b)
	  {
		  int i=0;
		  int finalSum=0;
		  int sum=0;
		  int carry=0;
		  while(a!=0 && b!=0){

		      System.out.println("sum="+Integer.toBinaryString(sum));
		      System.out.println("carry="+Integer.toBinaryString(carry));
		      System.out.println("a="+Integer.toBinaryString(a));
		      System.out.println("b="+Integer.toBinaryString(b));
		      System.out.println("final="+Integer.toBinaryString(finalSum));
			  sum = (a&1) ^ (b&1);
			  sum =sum ^ carry;
			  carry = a&b ^ (carry & (a ^ b));
			  finalSum = finalSum |sum;
			  finalSum = 1<<finalSum;
			  a=a>>1;
		      b=b>>1;
		      i++;
		      //System.out.println("a="+Integer.toBinaryString(sum));
		     // System.out.println("sum="+Integer.toBinaryString(carry));
		  }
		  System.out.println(finalSum);
	  }
	  
	public  int Add(int x, int y)
	  {
	      // Iterate till there is no carry  
		//addBinaryStrings(Integer.toBinaryString(x),Integer.toBinaryString(y));
	      while (y != 0)
	      {
	          int carry = x & y;  
	   
	          // Sum of bits of x and y where at least one of the bits is not set
	          x = x ^ y; 
	   
	          // Carry is shifted by one so that adding it to x gives the required sum
	          y = carry << 1;
	      }
	     System.out.println(x);
	     
	      return x;
	  }
	public  int substract(int x, int y)
	  {
	      // Iterate till there is no carry  
		//addBinaryStrings(Integer.toBinaryString(x),Integer.toBinaryString(y));
		y=~y;
		y++;
	      while (y != 0)
	      {
	          int carry = x & y;  
	   
	          // Sum of bits of x and y where at least one of the bits is not set
	          x = x ^ y; 
	   
	          // Carry is shifted by one so that adding it to x gives the required sum
	          y = carry << 1;
	      }
	     System.out.println(x);
	     
	      return x;
	  }
	
	public void addBinaryStrings(String str1,String str2)
	{
		str1 = new String(new char[32-str1.length()]).replace("\0", "0") +str1;
		str2 = new String(new char[32-str2.length()]).replace("\0", "0") +str2;
		System.out.println(str1);
		System.out.println(str2);
		//System.out.println(str2.length() - str2.replace("0", "").length());
		while(str2.length() - str2.replace("0", "").length()!=32)
		{
			String carry = and(str1,str2);
			str1 =xor( str1, str2);
			//left shift
			String firstChar = carry.substring(0, 1);
			str2 = carry.substring(1) +"0";
			str2 = firstChar + str2.substring(1);
			System.out.println("carry= " + carry);
			System.out.println("str1 = " + str1);
			System.out.println("str2 = " + str2);
		}
		System.out.println("String = " + Integer.parseInt(str1,2));
	}
		
	public String xor(String str1,String str2)
	{
		System.out.println("len = " + str1.length());
		StringBuilder sb = new StringBuilder(); 
		for(int i=0 ; i<32 ;i++)
			sb.append( ((str1.charAt(i)=='0' && str2.charAt(i)=='0') ||(str1.charAt(i)=='1' && str2.charAt(i)=='1'))?"0":"1");
		return sb.toString();
	}
	
	   public int findComplement(int num) {
	        int complementer = (Integer.highestOneBit(num)<<1) -1;
	        System.out.println(Integer.toBinaryString(num));
	        System.out.println(Integer.toBinaryString(complementer));
	        return num ^ complementer;
	        
	    }
	public String and(String str1,String str2)
	{
		StringBuilder sb = new StringBuilder(); 
		for(int i=0 ; i<32 ;i++)
			sb.append( ((str1.charAt(i)=='1' && str2.charAt(i)=='1'))?"1":"0");
		return sb.toString();
	}
	  public static void main(String[] args)
	  {
		  BitWiseOperator b = new BitWiseOperator();
		  //System.out.println("String = " + Integer.parseInt("10111111111111111111111111111100",2));
		 //b.addTwoNumbers(1, 1);
		  b.findComplement(10);
		  b.substract(1, 1);
		 // b.Add(10,-12);
		//  b.addBinaryStrings("1101", "101");
		//  System.out.println(b.xor("1111", "1010"));
		// b.reverseBits(-32);
		// System.out.println(b.hammingWeight(0));
	  }

}
