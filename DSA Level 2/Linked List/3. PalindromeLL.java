// Given a singly linked list of Integers, determine it is a palindrome or not.
// Input Format
// 1->2->3->4->3->2->1->null
// 1->2->3->4->2->1->null
// Output Format
// true
// false

/*
Sample Input
10
5
1
4
6
9
9
6
4
1
5
Sample Output
true
*/






//__________________________________________________________

//1. Reverse 2nd half of ll
    //2. Find mid-node
    //3. newHead=middle.next, de-link both half by middle.next=null
    //4. then reverse 2nd half
    //newHead becomes "tail" node then
    // 5. new pointers should be at head and newHead
    //LL looks like: 1->2->3 3<-2<-1
    // 6. check values, if diff, return false, else move p1 and p2 to their next nodes
    //after checking LL, we can reverse LL to rearrange it in original way = Reverse 2nd half, join it to 1st half
    //7. return result

    import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid= midNode(head);
        // System.out.println(mid.val);
        ListNode nHead=mid.next;
        // System.out.print(nHead.val);
        mid.next=null;
        nHead = reverse(nHead);
        
        
        ListNode p1=head;
        ListNode p2=nHead;
        boolean flag=true;
        while(p1!=null){
            if(p1.val!=p2.val){
                flag=false;
                break;
            }
            p1=p1.next;
            p2=p2.next;
        }
        
        nHead = reverse(nHead);
        mid.next=nHead;
        
        return flag;
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
    
    public static ListNode midNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        
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

        System.out.println(isPalindrome(dummy.next));
    }
}