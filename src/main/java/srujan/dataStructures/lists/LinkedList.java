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
public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head==null) return null;
    if(head.next==null) return head;
    ListNode node = head;
    ListNode first = null;
    int i=1;
    while(i <m)
    {
        first =node;
        node =node.next;
        i++;
    }
    //System.out.println("first:"+first.val);
    int j=m;
    ListNode revHead  =node;
    System.out.println("revHead:"+revHead.val);
    ListNode prev =null;
    ListNode next = null;
    while(j<=n)                                                                                                                          
    {
        System.out.println(j+":"+node!=null?node.val:-1);
        System.out.print("Prev");
        if(prev!=null)
        System.out.println(":"+prev.val);
        next =node.next;
        node.next=prev;
        prev=node;
        node =next;
        j++;

    }//1->2->x
    System.out.println("Out Of Loop");
     System.out.println("revHead:"+revHead.val);
    //  System.out.println("first:"+first.val);
    revHead.next=next;
    if(first!=null){
    	first.next =prev;
    	return first;
    }
    else
    	return prev;
    
    
}

public void printList(ListNode root)
{
	while(root!=null)
	{
		System.out.println(root.val +"->");
		root = root.next;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public static void main(String[] args)
{
	ListNode l1 = new ListNode(1);
	ListNode l2 = new ListNode(2);
	ListNode l3 = new ListNode(3);
	ListNode l4 = new ListNode(4);
	l1.next=l2;
	/*l2.next=l3;l3.next=l4;l4.next=l1;*/

	LinkedList l = new LinkedList();
	l.printList(l.reverseBetween(l1,1,2));
	l.detectCycle(l1);
}
	
}


 
 