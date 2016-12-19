package srujan.alogs.strings;

import java.util.Stack;

public class ReversePolish {
	

public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();

        for(int i=0 ;i<tokens.length ; i++)
        {
            if(tokens[i].matches("-?\\d+(\\.\\d+)?"))
               stack.push(Integer.parseInt(tokens[i]));
            else
            {
            	 stack.push(operate(stack.pop(),tokens[i],stack.pop()));
            }
        }
        
        return stack.pop();
        
    }

 public int operate(int j,String operator, int i)
 {
	 if(operator.equals("/"))
		return i/j ;
	 else if(operator.equals("+"))
		 return i+j ; 
	 else if(operator.equals("-"))
		 return i-j ;
	 else
		 return i*j ; 
 
 }
	public static void main(String args[])
	{
		String[] str = {"4", "13", "5", "/", "+"};
		System.out.println(new ReversePolish().evalRPN(str));
	}
	

}
