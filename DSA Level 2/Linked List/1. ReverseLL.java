/*
You have given a pointer to the head node of a linked list, the task is to reverse the linked list. 
We need to reverse the list by changing the links between nodes.
Input Format
1->2->3->4->5->6->7->null
Output Format
7->6->5->4->3->2->1->null

Sample Input
7
1 2 3 4 5 6 7
Sample Output
7 6 5 4 3 2 1
*/

//__________________________________________________________
//head is given as curr node initially
/*


len=0, works
len=1, works
len=2, works
prev=null
// do this till
 while(curr!=null){
    

    //Step 1: assign neighbour
    nbr=curr.next
    //Step 2: change link to prev node, prev link breaks
    curr.next=prev

    //Step 3: change prev to curr node, and curr node to nbr
    prev=curr
    curr=nbr
}
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

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = reverse(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
head = head.next;
        }
    }
}