
1. Given a singly linklist, Segregate Node of LinkedList over lastindex and return pivot node of linkedlist.
2. pivot is always be last index of linkedlist.
3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.
Input Format
1->5->2->9->5->14->11->1->10->10->1->3->null
Output Format
3->5->9->5->14->11->10->10->null 


Sample Input
12
1 5 2 9 5 14 11 1 10 10 1 3 
Sample Output
3 5 9 5 14 11 10 10 
__________________________________________________________________________________
ListNode dummySmaller= new ListNode(-1);
ListNode prevSmaller=dummySmaller;
ListNode dummyLarger= new ListNode(-1);
ListNode prevLarger=dummyLarger;

ListNodecurr=head;

while(curr!=null){
    if(curr.val<=pivot.val){ //if smaller than pivot, put it in the list that will be attached behind pivot
        prevSmaller.next=curr;
        prevSmaller=prevSmaller.next;
        curr=curr.next;
    }else{ //otherwise put it in another list
        prevLarger.next=curr;
        prevLarger=prevLarger.next;
        curr=curr.next;
    }
}

// prevSmaller.next=pivot;
prevSmaller.next=dummyLarger.next;

prevLarger.next=null;//prevent loop


__________________________________________________________________________________
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
    
    public static int getTail(ListNode head){
        if(head==null){
            return Integer.MIN_VALUE;
        }
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        
        return curr.val;
    }
    public static ListNode segregateOnLastIndex(ListNode head) {
        int tail= getTail(head);
        
        ListNode dummySmaller= new ListNode(-1);
        ListNode prevSmaller=dummySmaller;
        ListNode dummyLarger= new ListNode(-1);
        ListNode prevLarger=dummyLarger;
        
        ListNode curr=head;
        
        while(curr!=null){
            if(curr.val<=tail){ //if smaller than pivot, put it in the list that will be attached behind pivot
                prevSmaller.next=curr;
                prevSmaller=prevSmaller.next;
                curr=curr.next;
            }else{ //otherwise put it in another list
                prevLarger.next=curr;
                prevLarger=prevLarger.next;
                curr=curr.next;
            }
        }
        
        // prevSmaller.next=pivot;
        prevSmaller.next=dummyLarger.next;
        
        prevLarger.next=null;//prevent loop
        
        return prevSmaller;
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}