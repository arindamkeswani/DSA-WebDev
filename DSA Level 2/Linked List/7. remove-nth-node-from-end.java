/*
Given a singly linklist, remove the nth node from the end of the list and return its head.
Input Format
1->7->2->6->3->5->4->null
2
Output Format
1->7->2->6->3->4->null

Sample Input
9
18 1 16 11 15 7 9 16 4 
1
Sample Output
18 1 16 11 15 7 9 16 
*/

/*________________________________________________________________
//take 2 pointers:slow and fast
// Run fast node to kth position
while(fast.next!=null){
// then move slow and fast node together till fast node.next!=null
    fast=fast.next;
    slow=slow.next;
}
//nbr=slow.next //nbr is the node we want to remove
//slow.next=nbr.next
// nbr.next=null
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

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if(head==null||head.next==null){
        return head;
    }
    
    ListNode slow=head;
    ListNode fast=head;
    
    for(int i=0;i<n;i++){
        fast=fast.next;
    }
    
    if(fast==null){
        return head.next;
    }
    while(fast.next!=null){
        fast=fast.next;
        slow=slow.next;
    }
    
    ListNode nbr=slow.next;
    slow.next=nbr.next;
    nbr.next=null;
    
    return head;
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

    int m = scn.nextInt();
    h1 = removeNthFromEnd(h1, m);
    printList(h1);
  }
}