1. You are given a partially written DoublyLinkedList class.
2. You are required to complete the body of addLast function. This function is supposed to add an element to the front of LinkedList. You are required to update head, tail and size as required.
3. Input and Output is managed for you. Just update the code in addLast function.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge cant 
        force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
input in managed for you.
Output Format
output in managed for you.

Sample Input
addFirst 4
addFirst 4
addLast 5
addFirst 7
addLast 1
stop
Sample Output
[7, 4, 4, 5, 1]
______________________________________________________________
Node node=new Node(data);
if(size==0){
    head=tail=node;
}
else{
    tail.next=node;
    node.prev=tail;
    tail=node;
}
size++;
______________________________________________________________

import java.util.*;

class Main {

  public static class DoublyLinkedList {
    private class Node {
      int data = 0;
      Node prev = null;
      Node next = null;

      Node(int data) {
        this.data = data;
      }

    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node curr = this.head;
      sb.append("[");
      while (curr != null) {
        sb.append(curr.data);
        if (curr.next != null)
          sb.append(", ");
        curr = curr.next;
      }
      sb.append("]");

      return sb.toString();
    }

    private void addFirstNode(Node node) {
      if (this.size == 0)
        this.head = this.tail = node;
      else {
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
      }
      this.size++;
    }

    public void addFirst(int val) {
      Node node = new Node(val);
      addFirstNode(node);
    }

    public void addLast(int val) {
      // complete this function.
      Node node=new Node(val);
        if(size==0){
            head=tail=node;
        }
        else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        size++;
    }

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    DoublyLinkedList dll = new DoublyLinkedList();

    String str = scn.nextLine();
    while (!str.equals("stop")) {
      String[] s = str.split(" ");
      if (s[0].equals("addFirst"))
        dll.addFirst(Integer.parseInt(s[1]));
      else if (s[0].equals("addLast"))
        dll.addLast(Integer.parseInt(s[1]));

      str = scn.nextLine();
    }

    System.out.println(dll);
  }
}