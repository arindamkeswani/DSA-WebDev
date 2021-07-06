// 1. Given a singly linklist with an additional random pointer which could point to any node in the list or NULL.
// 2. Return a deep copy of the list.
// 3. For More Details watch Video.
// Input Format
// input is handle for you
// Output Format
// output is handle for you.

// Sample Input
// 5
// 7 -1
// 15 0
// 18 4
// 10 2
// 5 0
// Sample Output
// (7, -1) (15, 7) (18, 5) (10, 18) (5, 7) 

Shallow copy: Shared- Anyone making a change will reflect it for everybody else
Deep copy: Not shared, changes are private and not visible to everybody. Everone has their own copy, but will take more space


// Store details of random node in hashmap for every node
make a deep copy without random node
Store details of copied node in hashmap for every node, with null reference for null point

cnode.random = map.get(node.random);


__________________________
import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode copyRandomList(ListNode head) {
        if(head==null){
            return null;
        }
        HashMap<ListNode, ListNode> hm=new HashMap<>();
        hm.put(null,null);
        ListNode dummy= new ListNode(-1);
        ListNode curr=head, prev=dummy;
        
        while(curr!=null){
            ListNode node=new ListNode(curr.val);
            prev.next=node;
            hm.put(curr,node);
            
            prev=prev.next;
            curr=curr.next;
        }
        
        ListNode oNode= head, cNode=dummy.next;
        
        while(oNode!=null){
            cNode.random = hm.get(oNode.random);
            
            cNode=cNode.next;
            oNode=oNode.next;
            
        }
        
        return dummy.next;
        // ListNode cNode=new ListNode(head.val);
        // ListNode tail=cNode;
        // ListNode p=head;
        // while(p!=null){
        //     tail.next= new ListNode(p.next.val);
        //     tail=tail.next;
        //     p=p.next;
        // }
        
        // HashMap<ListNode, ListNode> hm=new HashMap<>();
        
        // p=head;
        // tail=cNode;
        
        // while(p!=null){
        //     hm.put(p, tail);
        //     p=p.next;
        //     tail=tail.next;
        // }
        // hm.put(null,null);
        
        // tail=cNode;
        // p=head;
        // while(p!=null){
        //     tail.random = hm.get(p).random;
        //     p=p.next;
        //     tail.tail
        // }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}