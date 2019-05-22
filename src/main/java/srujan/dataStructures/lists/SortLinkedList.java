package srujan.dataStructures.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
    	
    	
        if(head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next ;
        }
        ListNode rightHead = sortList(slow.next);
        slow.next = null;
        ListNode leftHead = sortList(head);
        return merge(leftHead,rightHead);
    }
    public ListNode merge(ListNode leftHead, ListNode rightHead){
        ListNode left  = leftHead;
        ListNode right = rightHead;
        ListNode finalHead ;
        if(left.val <= right.val){
            finalHead = left;
            left = left.next;
        }
        else{
            finalHead = right;
            right = right.next;
        }
        ListNode curNode = finalHead.next;
        while(left!= null && right!= null){
            if(left.val <= right.val){
            curNode = left;
            left = left.next;
        }
        else{
            curNode = right;
            right = right.next;
        }
            curNode = curNode.next;
        
        if(left!=null)
            curNode = left;
        else
            curNode = right;
        }
        return finalHead;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        System.out.println("Main: "+list.toString());
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            System.out.println("TempList"+tempList.toString());
            tempList.remove(tempList.size() - 1);
            System.out.println("AFter"+tempList.toString());
        }
        System.out.println("Endbacktrack");
    }
    public List<List<Integer>> recCombiner(int start, int n,int k){
        List<List<Integer>> finalList = new ArrayList<>();
        if((n+1 - start) < k)
            return finalList;
        else if(k == 1 ) {
        	
        	finalList.add (new ArrayList<Integer>() {{add(start);}});
        	finalList.addAll(recCombiner(start + 1 , n, k ));
        }
        else {
                for (int i = start ;i <= n ; i++)
                {
                    List<List<Integer>> tempList = recCombiner(i +1 , n, k -1);
                    for(List<Integer> list : tempList)
                        list.add(i);
                    finalList.addAll(tempList);
                }
         }
        return finalList;
                                           
        }     
    
}

