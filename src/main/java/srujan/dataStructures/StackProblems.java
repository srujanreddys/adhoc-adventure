package srujan.dataStructures;

import java.util.LinkedList;

public class StackProblems {
	
	public static void main(String[] args)
	{
		MinStack m = new MinStack();
		m.push(-2);
		m.push(0);
		m.push(-3);
		System.out.println(m.getMin());
		System.out.println(m.top());
		m.pop();
		//System.out.println(m.pop());
		System.out.println(m.top());
		System.out.println(m.getMin());
	}

}

 class MinStack {

    /** initialize your data structure here. */
	  LinkedList<Integer> stack1 ;
	  LinkedList<Integer> stack2 ;
	  LinkedList<Integer> curStack ;
	  LinkedList<Integer> otherStack ;
	  int min =Integer.MAX_VALUE;
    public MinStack() {
    	stack2 = new LinkedList<>();
    	stack1= new LinkedList<>();
    	curStack = stack1;
    	otherStack =stack2;
    }
    
    public void push(int x) {
        if(x<min)
        	min=x;
        curStack.push(x);
    }
    
    public void pop() {
      if(!curStack.isEmpty()){
    	int x = curStack.pop();
    	if(x==min)
    	{
    		int locMin=Integer.MAX_VALUE;;
    		while(!curStack.isEmpty())
    		{
    			int cur =curStack.pop();
    			if(cur<locMin)
    				locMin=cur;
    			otherStack.push(cur);
    		}
    		while(!otherStack.isEmpty())
    		{
    			curStack.push(otherStack.pop());
    		}
    		min=locMin;
    		//LinkedList<Integer> temp= curStack;
    		//curStack=otherStack;
    		//otherStack=temp;
    	}
      }
    }
    
    public int top() {
    	if(!curStack.isEmpty()){
    		return curStack.peek();
    	}
    	else return -1;
    }
    
    public int getMin() {
        return min;
    }
}