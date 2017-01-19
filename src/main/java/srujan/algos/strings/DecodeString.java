package srujan.algos.strings;

public class DecodeString {

	public String decodeString1(String s)
	{
		   
    	if(s==null ||s.length()==0)
    		return "";
        if(Character.isDigit(s.charAt(0)))
        {
            return repeat(getInt(s), decodeString1(getCompletSet(s.substring(s.indexOf("["))))) 
            		+ decodeString1(getCompletSetAfter(s.substring(s.indexOf("["))));
        }
       
        
        else
        {
           String chars= getChar(s);
            return chars + decodeString1(s.substring(findIntLoc(s)));
        }
    }
    public  String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

    public String getCompletSet(String str)
    {
        int openCount=1;
        int closeCount=0;
        int i=1;
        StringBuilder sb = new StringBuilder();
        while( (openCount!=closeCount) &&i<str.length() )
        {
        	if(str.charAt(i)=='[')
        		openCount++;
        	else if(str.charAt(i)==']')
        		closeCount++;
            sb.append(str.charAt(i));
        	i++;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
        
    }
    public String getCompletSetAfter(String str)
    {
        int openCount=1;
        int closeCount=0;
        int i=1;
        while( i<str.length() && (openCount!=closeCount)  )
        {
        	if(str.charAt(i)=='[')
        		openCount++;
        	else if(str.charAt(i)==']')
        		closeCount++;
        	i++;
        }
        
        return str.substring(i);
        
    }
    
    public String getChar(String str)
    {
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i<str.length() && (!Character.isDigit(str.charAt(i))) )
        {
            sb.append(str.charAt(i));
            i++;
        }
        return sb.toString();
    }
    
     public int findIntLoc(String str)
    {
        int i=0;
        while(i<str.length() &&(!Character.isDigit(str.charAt(i))))
        {
            i++;
        }
        return i;
    }
     public int getInt(String str)
     {
    	 int i=0;
	        StringBuilder sb = new StringBuilder();
	        while( i<str.length() && (Character.isDigit(str.charAt(i))) )
	        {
	            sb.append(str.charAt(i));
	            i++;
	        }
	        return Integer.parseInt(sb.toString()) ;
     }
	public static void main(String args[])
	{
		 String s = "3[a2[c]]";//, return "accaccacc".
		
		 DecodeString g = new DecodeString();
		 System.out.println(g.decodeString1(s));
		 System.out.println(g.decodeString1("3[a]2[bc]"));
		 System.out.println(g.decodeString1("2[abc]3[cd]ef"));
		}

}
