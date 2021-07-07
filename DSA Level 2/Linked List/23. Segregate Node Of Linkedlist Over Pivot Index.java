1. Given a singly linklist, Segregate Node of LinkedList over pivot index and return starting node of linkedlist.
2. pivot will be any random index in range of 0 to length Of Linkedlist
3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.
Input Format
1->5->2->9->5->14->11->1->10->10->1->3->null
11
Output Format
1->2->1->1->3->5->9->5->14->11->10->10->null 

Sample Input
12
1 5 2 9 5 14 11 1 10 10 1 3 
7
Sample Output
1 1 1 5 2 9 5 14 11 10 10 3 
________________________________________________________________
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
    public static int getPivot(ListNode head , int pivotIdx){
        ListNode curr=head;
        int count=0;
        while(count!=pivotIdx && curr!=null){
            curr=curr.next;
            count++;
        }
        
        return curr.val;
    }
  public static ListNode segregate(ListNode head, int pivotIdx) {
        int pivotVal= getPivot(head, pivotIdx);
        
        ListNode dummySmaller= new ListNode(-1);
        ListNode prevSmaller=dummySmaller;
        ListNode dummyLarger= new ListNode(-1);
        ListNode prevLarger=dummyLarger;
        ListNode pivot=null;
        // ListNode prevPivot=pivot;
        // boolean flag=false;
        ListNode curr=head;
        int idx=0;
        while(curr!=null){
            if(idx==pivotIdx){
                pivot=curr;
                curr=curr.next;
            }
            else if(curr.val<=pivotVal){ //if smaller than (or equal to, for multiple occurances) pivot, put it in the list that will be attached behind pivot
                prevSmaller.next=curr;
                prevSmaller=prevSmaller.next;
                curr=curr.next;
            }else{ //otherwise put it in another list
                prevLarger.next=curr;
                prevLarger=prevLarger.next;
                curr=curr.next;
            }
            
            idx++;
        }
        
        prevSmaller.next=pivot;
        
        pivot.next=dummyLarger.next;
        prevLarger.next=null;//prevent loop
        
        return dummySmaller.next;
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
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}