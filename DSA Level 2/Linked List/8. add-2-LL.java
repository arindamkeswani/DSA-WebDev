/*
1. You are give two single linkedlist of digits. 
2. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input Format
1->2->3->4->5->6->7->null
7->8->9->null
Output Format
1->2->3->5->3->5->6->null

Sample Input
6
6 1 3 2 4 0 
2
3 5 
Sample Output
6 1 3 2 7 5 
*/



/*________________________________________________________________
//reverse both lists
//set p1 to h1
//set p2 to h2

//init 3rd list with head=-1, p3=h3

while(p1!=null){
    if(p2==null){
        tempSum=p1;
    }else{
        add p1+p2 data values+carry, store carry
    }
    

    move p1,p2,p3 to next 
}

remove -1 node from sum LL
reverse all 3 lists
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
    public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
        if(h1==null||h2==null){
            return h1==null?h2:h1;
        }
        h1=reverse(h1);
        h2=reverse(h2);
        
        ListNode res= new ListNode(-1);
        ListNode p1=h1, p2=h2, p3=res;
        
        int carry=0;
        
        while(carry!=0 || p1!=null || p2!=null){
            int v1=(p1==null) ? 0 : p1.val;
            int v2=(p2==null) ? 0 : p2.val;
        
            int sum=v1+v2 + carry;
            carry=sum/10;
            sum=sum%10;
        
            ListNode node=new ListNode(sum);
            p3.next=node;
        
            p1=(p1==null) ?null: p1.next;
            p2=(p2==null) ?null: p2.next;
            p3=p3.next;
        }
        
        ListNode temp=res;
        res=res.next;
        temp.next=null;
        
        h1=reverse(h1);
        h2=reverse(h2);
        res=reverse(res);
        
        return res;
            
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

        ListNode ans = addTwoNumbers(head1, head2);
        printList(ans);
    }

}