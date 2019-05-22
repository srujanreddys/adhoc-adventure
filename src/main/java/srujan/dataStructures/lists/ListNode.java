package srujan.dataStructures.lists;



 public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

public void printList(ListNode root)
{
	while(root!=null)
	{
		System.out.print(root.val +"->");
		root = root.next;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
