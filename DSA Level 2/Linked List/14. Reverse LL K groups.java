1. Given a singly linklist, reverse the nodes of a linked list k at a time and return its modified linkedlist.
2. If number of nodes in multiple of k then it will reverse otherwise it will add inn the end of linkedlist without any change.
Input Format
1->5->2->9->5->14->11->1->10->10->1->3->null
2
Output Format
11->14->5->9->2->5->1->10->10->1->3->null
____________________________________________
add first till k nodes to temp head
//addFirst logic
if(tHead==null){
    th=tT=curr;
}else{
    curr.next=tH;
    tH=curr;
}

//
while(curr!=null){
    fwd=curr.next;
    curr.next=null;
    addFirst(curr,tHead);
    curr=fwd;
}

//after every group
if(fHead==null){
    fHead=th;
    fTail=tT;
    tT=tH=null;
}else{
    ft.next=tHead;
    ft=tt;
}
-------------------------------
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
    
    public static int length(ListNode node){
        ListNode curr= node;
        int len=0;
        while(curr!=null){
            curr=curr.next;
            len++;
        }
        
        return len;
    }
    
    static ListNode tHead= null;
    static ListNode tTail= null;
    
    static ListNode fHead= null;
    static ListNode fTail= null;
    public static void addFirst(ListNode node){
        if(tHead==null){
            tHead=tTail=node;
        }else{
            node.next=tHead;
            tHead=node;
        }
    }
    public static ListNode reverseInKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k<1){
            return head;
        }
        
        int len=length(head);
        ListNode curr=head;
        while(len>=k)
        {
            int tempK=k;
            while(tempK-- >0){
                ListNode fwd = curr.next;
                curr.next=null;
                addFirst(curr);
                curr=fwd;
                
            }
            if(fHead==null){
                fHead=tHead;
                fTail=tTail;
                tTail=tHead=null;
            }else{
                fTail.next=tHead;
                fTail=tTail;
            }
            
            tHead=null;
            tTail=null;
            len-=k;
        }
        fTail.next=curr;
        return fHead;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}
 // if(head==null){
        //     return null;
        // }
        
        // ListNode curr=head;
        // tHead = head;
        // tTail=head;
        
        // fHead=null;
        // while(curr!=null){
        //     counter=k;
            
        //     while(k>0){
        //         fwd=curr.next;
        //         curr.next=null;
                
        //         //addFirst logic
        //         if(tHead==null){
        //             tHead=tTail=curr;
        //         }else{
        //             curr.next=tH;
        //             tHead=curr;
        //         }
                
        //         curr=fwd; 
        //         k--;
        //     }
        //     //after every group
        //     if(fHead==null){
        //         fHead=tHead;
        //         fTail=tTail;
        //         tTail=tHead=null;
        //     }else{
        //         ft.next=tHead;
        //         ft=tt;
        //     }
        // }