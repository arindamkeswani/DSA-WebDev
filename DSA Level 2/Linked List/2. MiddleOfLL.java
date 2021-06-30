/*
Middle Of A Linked List
Easy  Prev   Next
given a singly linked list with head node head, return a middle node of linked list.
if there is 2 mid node then return first mid node.
Input Format
1->2->3->4->5->6->7->null
1->2->3->4->5->6->null
Output Format
4->5->6->7->null
3->4->5->6->null


Sample Input
7
1 2 3 4 5 6 7
Sample Output
4 5 6 7 
*/


//__________________________________________________________
//2 pointers
//ODD: till fast.next!=null
//EVEN: fast.next.next!=null

import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode midNode(ListNode head) {


        ListNode slow=head;
        ListNode fast=head;
        if(head==null||head.next==null){
            return head;
        }
        while(fast.next!=null && fast.next.next!=null){ //for odd and even condn
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
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

        ListNode head = midNode(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}