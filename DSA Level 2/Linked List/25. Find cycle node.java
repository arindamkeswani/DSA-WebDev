1. Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
2. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.

Notice that you should not modify the linked list.
Input Format
input is handle for you
Output Format
output is handle for you

Sample Input
8
1
18
1
8
-1
138
31
84
3
Sample Output
8
____________________________________
ListNode fast=head;
ListNode slow=head;


while(fast!=null && fast.next!=null){
    slow=slow.next;
    fast=fast.next.next;
    if(slow==fast){
        
        break;
    }
}

if(fast!=slow){
    return null;
}

//if code reaches here, that means we have established that cycle exists
fast=head;
while(fast!=slow){
    fast=fast.next.next;
    slow=slow.next;
}

return slow;

____________________________________
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

    public static ListNode CycleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        
        if(fast!=slow){
            return null;
        }
        
        //if code reaches here, that means we have established that cycle exists
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
            
        }
        
        return slow;
    }

    public static ListNode takeInput() {
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        int idx = scn.nextInt();
        if (idx >= 0) {
            ListNode curr = dummy.next;
            while (idx-- > 0) {
                curr = curr.next;
            }
            prev.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = takeInput();
        ListNode ans = CycleNode(head);
        System.out.println(ans!=null?ans.val:-1);
    }
}