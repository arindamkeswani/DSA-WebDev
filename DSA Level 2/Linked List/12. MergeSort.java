Given the head of a linked list, return the list after sorting it in increasing order.
Time Complexity : O(nlogn)
Space Complexity : constant space 
Input Format
1->7->2->6->3->5->4->null
Output Format
1->2->3->4->5->6->7->null

Sample Input
4
0
6
7
5
Sample Output
0 5 6 7 

_____________________________________________________________
get mid element
make fwd pointer (head of second half)
break link between mid and forward

if(head.next==null){//when only 1 element left, use Merge2SortedLists logic to combnine mid anf fwd elements  
    return new ListNode(head.val);
}

then mid.next=fwd//connect link



_____________________________________________________________

import java.util.*;

class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null && l2==null){
            return null;
        }
        else if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        
        ListNode resNode=new ListNode(-1); //head of result
        ListNode tail=resNode;
        
        ListNode p1=l1;
        ListNode p2=l2;
        
        while(p1!=null || p2!=null){
            ListNode temp;
            if(p1==null){
                temp=p2;
            }
            else if(p2==null){
                temp=p1;
            }else{
                temp= p1.val < p2.val ? p1 : p2;
            }
            
            tail.next = temp;
            // System.out.print(temp.val+" ");
            tail=temp;
            
            if(temp==p1){
                p1=temp.next;
            }else{
                p2=temp.next;
            }
            
            
        }
        
        return resNode.next;
    }
    
    public static ListNode mergeSort(ListNode head) {
        //Take out mid node
        
        if(head==null){
            return null;
        }
        
        if(head.next==null){
            return new ListNode(head.val);
        }
        
        ListNode slow=head;
        ListNode fast=head;
        
        if(head==null||head.next==null){
            return head;
        }
        while(fast.next!=null && fast.next.next!=null){ //for odd and even condn
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode mid=slow;
        ListNode fwd=mid.next;
        
        mid.next=null;
        ListNode lHead = mergeSort(head);
        ListNode rHead = mergeSort(fwd);
        
        mid.next=fwd;
        
        
        
        return mergeTwoLists(lHead, rHead);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);

        ListNode head = mergeSort(h1);
        printList(head);
    }
}