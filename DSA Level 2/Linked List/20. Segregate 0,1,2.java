1. Given a singly linklist, Segregate 012 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and then ones node followed by twos nodes.
3. You are only allowed to swap data not swap nodes.
Input Format
1->0->1->0->0->1->2->1->1->1->2->1->1->null
Output Format
0->0->0->1->1->1->1->1->1->1->1->2->2->null


Sample Input
17
2 2 0 2 1 0 0 2 2 1 2 1 2 0 1 0 0 
Sample Output
0 0 0 0 0 0 1 1 1 1 2 2 2 2 2 2 2 
__________________________________________________
while(i!=null){
    if(i.val==2){
        i=i.next;
    }
    if(i.val==1){
        swap(k,i);
        i=i.next;
        k=k.next;
    }
    if(i.val==0){
        swap(i,j); //0 will be pushed back but 1 will come after 2
        swap(i,k); //1 will be pushed back in place, 2 will come forward
        i=i.next; 
        j=j.next;
        k=k.next;
    }
}
__________________________________________________
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
    public static ListNode segregate012(ListNode head) {
        
        if(head==null){
            return head;
        }
        
        ListNode i=head;
        ListNode j=head;
        ListNode k=head;
        
        while(i!=null){
            if(i.val==2){
                i=i.next;
            }
            else if(i.val==1){
                swap(i,k);
                i=i.next;
                k=k.next;
            }
            else if(i.val==0){
                swap(i,j); //0 will be pushed back but 1 might come after 2
                if(i.val==1){ //Do not swap again if encountering 2 again
                    swap(i,k); //1 will be pushed back in place, 2 will come forward
                }
                
                i=i.next; 
                j=j.next;
                k=k.next;
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
        h1 = segregate012(h1);
        printList(h1);
    }
}