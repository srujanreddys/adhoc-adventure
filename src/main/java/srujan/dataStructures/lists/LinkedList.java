package srujan.dataStructures.lists;

public class LinkedList {

public boolean hasCycle(ListNode head) {
	
	if(head==null ||head.next==null ||head.next.next==null)
		return false;
	ListNode slow = head;
	ListNode fast = head.next.next;

	 while (fast!=slow && fast!=null && fast.next!=null)
	 {
		 slow=slow.next;
		 fast=fast.next.next;
	 }
	 if(fast==slow)
		 return true;
	 else
		 return false;
    }

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	ListNode p1 = headA;
	ListNode p2 = headB;
    while(p1!=null && p2!=null )
    {
       if(p1==p2)break;
        if(p1.next!=null)p1=p1.next;else p1=headB;
        if(p2.next!=null) p2=p2.next;else p2 =headA;
         
    }
    if( p1==null ||p2==null)
    	return null;
    else
    	return p1;
    
}

public ListNode detectCycle(ListNode head)
{
	
	ListNode slow = head;
	ListNode fast = head;

	 while ( fast!=null && fast.next!=null)
	 {
		 slow=slow.next;
		 fast=fast.next.next;
		 if(fast==slow)
		 {
			 ListNode slow2 =head;
			 while(fast!=slow2)
			 {
				 slow2=slow2.next;
				 fast=fast.next;
		     }
			 return slow2;
		 }
	 }
	 
	 return null;
    
}

public static void main(String[] args)
{
	ListNode l1 = new ListNode(1);
	ListNode l2 = new ListNode(2);
	ListNode l3 = new ListNode(3);
	ListNode l4 = new ListNode(4);
	l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l1;
	
	LinkedList l = new LinkedList();
	l.detectCycle(l1);
}
	
}


 
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 