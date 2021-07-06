1. Merge two sorted linkedlists and return head of a sorted linkedlist. The list should be made by splicing together the nodes of the first two lists
2. Both list are sorted in increasing order.
Input Format
1->2->6->7->15->24->null
-1->0->6->17->25->null
Output Format
-1->0->1->2->6->6->7->15->17->24->25->null


Sample Input
2
1 5 
4
1 3 6 10 

Sample Output
1 1 3 5 6 10 
/*
resNode=new ListNode(-1); //head of result
tail=resNode;
We make 2 pointers
p1 and p2, [pointing to respective LL head]
 
while(p1!=null || p2!=null){
    //compare, change tail to next smaller value, change pointer

    p1=head of l1
    p2=head of l2

    check which is less and resNode.next= whichever pointer is less
    Increase pointer to next
    update tail to tail.next

    
}
*/

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
        ListNode h2 = createList(m);


        ListNode head = mergeTwoLists(h1, h2);
        printList(head);
    }
}