1. Given a singly linklist, Segregate 01 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and followed by ones node.

Input Format
1->0->1->0->0->1->1->1->1->1->1->null
Output Format
0->0->0->1->1->1->1->1->1->1->1->null

Sample Input
196
0 1 0 0 0 1 1 0 0 1 1 1 0 0 1 1 0 1 0 1 0 1 0 0 0 1 1 0 1 1 0 0 1 1 1 0 0 0 0 1 0 1 1 1 0 1 1 1 1 0 1 1 0 0 1 1 1 1 0 1 0 1 1 0 0 1 0 1 0 0 0 0 1 0 1 0 0 0 1 1 0 0 1 1 1 0 1 1 1 1 0 1 1 1 0 0 1 0 0 1 0 0 0 1 0 1 1 0 0 0 1 1 0 1 1 0 0 0 1 1 1 1 1 1 1 0 0 1 1 0 1 0 0 0 1 1 1 0 0 1 1 0 0 0 1 1 1 1 1 0 1 0 0 0 0 1 1 1 1 0 0 0 0 1 0 0 1 0 1 1 0 1 0 1 1 1 1 1 0 0 0 1 1 0 0 0 0 0 0 1 1 0 0 1 0 1 
Sample Output
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 
_____________________________________________________________
ALGO
iterate through all nodes
two pointers i and j

if 0 encountered, swap i and j, i++, j++
if 1 is encountered, do nothing, i++

while(i!=null){
    if(i.val==1){
        i=i.next;
    }else{
        swap(i,j);
        i=i.next;
        j=j.next;
    }
}

//swapping = 

//Basically we push the zeroes back, up till point j;
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
    
    public static void swap(ListNode a, ListNode b){
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
    }
    
    public static ListNode segregate01(ListNode head) {
        
        if(head==null){
            return head;
        }
        
        ListNode i=head;
        ListNode j=head;
        
        while(i!=null){
            if(i.val==1){
                i=i.next;
            }else{
                swap(i,j);
                i=i.next;
                j=j.next;
            }
        }
        
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
        h1 = segregate01(h1);
        printList(h1);
    }
}