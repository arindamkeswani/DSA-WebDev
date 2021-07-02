/*
1. You are given two single linkedlist of digits. 
2. The most significant digit comes first and each of their nodes contain a single digit. Multiply the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input Format
1->2->3->4->5->null
7->8->9->null
Output Format
9->7->4->0->2->0->6->null


Sample Input
6
6 1 3 2 4 0 
2
3 5 
Sample Output
2 1 4 6 3 4 0 0 
*/

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

    public static ListNode multipltOneDigit(ListNode head, int digit){
        ListNode dummy=new ListNode(1);
        ListNode ac= dummy; //answer current
        ListNode curr=head;
        int carry=0;
        
        while(curr!=null || carry!=0){
            int sum= carry + (curr!=null? curr.val:0)*digit;
            int dig=sum%10;
            carry=sum/10;
            
            ac.next=new ListNode(dig);
            
            if(curr!=null){
                curr=curr.next;
            }
            ac=ac.next;
        }
        
        return dummy.next;
    }
    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        l1=reverse(l1);
        l2=reverse(l2);
        
        // ListNode res= new ListNode(-1);
        ListNode p2=l2;
        ListNode dummy= new ListNode(-1);
        ListNode ansItr = dummy;
        
        while(p2!=null){
            ListNode prod = multipltOneDigit(l1,p2.val);
            p2=p2.next;
            
            addTwoNumbers(prod, ansItr);
            ansItr=ansItr.next;
        }
        return reverse(dummy.next);
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
    
    public static void addTwoNumbers(ListNode head, ListNode ansItr) {
        ListNode c1= head;
        ListNode c2= ansItr;
        
        int carry=0;
        while(c1!=null || carry!=0){
            int sum= carry + (c1!=null? c1.val:0)+(c2.next!=null? c2.next.val:0);
            int digit= sum%10;
            carry= sum/10;
            
            if(c2.next!=null){
                c2.next.val=digit;
            }else{
                c2.next=new ListNode(digit);
            }
            
            if(c1!=null){
                c1=c1.next;
            }
            c2=c2.next;
        }
        
        
        
    }
    // InFput_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}