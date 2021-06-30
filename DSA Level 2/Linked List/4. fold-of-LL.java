/*
Given a singly linkedlist : l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln 
reorder it : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... 

for more information watch video.
Input Format
1->2->3->4->5->6->7->null
Output Format
1->7->2->6->3->5->4->null

Sample Input
10
5
1
4
6
9
9
6
4
1
5
Sample Output
5 5 1 1 4 4 6 6 9 9 
*/

/*___________________________________________________
//similar to palindrome

//take out mid node
nhead=mid.next
//delinking
//reverse 2nd half

while(p2!=null){ //p2 will always reach null first
    tp1=p1.next
    tp2=p2.next

    p1.next=p2
    
    p2.next=tp1
    p1=tp1
    p2=tp2
}

return head;
*/

import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void fold(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        
        ListNode mid= midNode(head);
        ListNode nHead=mid.next;
        
        mid.next=null;
        nHead = reverse(nHead);
        
        ListNode p1=head;
        ListNode p2=nHead;
        
        while(p2!=null){ //p2 will always reach null first
            ListNode tp1=p1.next;
            ListNode tp2=p2.next;
        
            p1.next=p2;
            p2.next=tp1;
            
            p1=tp1;
            p2=tp2;
        }
        
        // return head;
    }
    
    public static ListNode reverse(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode nbr=null;
        while(head!=null){
            
            nbr=head.next;
            
            head.next=prev;
            
            prev=head;
            head=nbr;
            
        }
        
        return prev;
    }
    
    public static ListNode midNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null){ //for odd and even condn
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
    }
}