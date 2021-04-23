// Complete the LinkedList class having following functions : 
// 1. addLast(val) : add node to the end of linkedList
// 2. addFirst(val) : add node to the start of linkedList
// 3. addAt(idx,val) : add node to the idx pos of linkedList(starting index is 0).
// 4. removeFirst() : removes starting node of linkedList, incase of no element print "List is empty"
// 5. removeLast() : removes ending node of linkedList, incase of no element print "List is empty"
// 6. removeAt(idx) : removes indexed node of linkedList, incase of no element print "List is empty" & "Invalid args" incase of wrong input.
// 7. display() : print all elements of linkedList (ele1 -> ele2 -> ele3 -> .)
// 8. size() : print number of nodes in linkedList
// 9. getFirst() : get value of starting node, incase of no element print "List is empty".
// 10. getLast() : get value of ending node, incase of no element print "List is empty".
// 11. getAt(idx) : get value of indexed node, incase of no element print "List is empty" & "Invalid args" in case of wrong input stream.


import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        System.out.println("Node obj instantiated");
        this.data = data;
    }

    Node(int data , Node next){
        this(data);
        this.next = next;
    }
}
class LinkedList{
    private Node head , tail;
    private int size;

    LinkedList(){
        System.out.println("LinkedList obj instantiated");
        head = tail = null;
        size = 0;
    }

    void addLast(int val) {
      Node temp = new Node(val);
      
      temp.next = null;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    public int size() {
      return size;
    }

    public void display() {
      for (Node temp = head; temp != null; temp = temp.next) {
        System.out.print(temp.data + " -> ");
      }
      System.out.println(".");
    }

    public void removeFirst() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        head = head.next;
        size--;
      }
    }

    public int getFirst() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return head.data;
      }
    }

    public int getLast() {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else {
        return tail.data;
      }
    }

    public int getAt(int idx) {
      if (size == 0) {
        System.out.println("List is empty");
        return -1;
      } else if (idx < 0 || idx >= size) {
        System.out.println("Invalid argts");
        return -1;
      } else {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
          temp = temp.next;
        }
        return temp.data;
      }
    }

    public void addFirst(int val) {
      Node temp = new Node(val);
      
      temp.next = head;
      head = temp;

      if (size == 0) {
        tail = temp;
      }

      size++;
    }

    public void addAt(int idx, int val) {
      if (idx < 0 || idx > size) {
        System.out.println("Invalid args");
      } else if (idx == 0) {
        addFirst(val);
      } else if (idx == size) {
        addLast(val);
      } else {
        Node node = new Node(val);
        

        Node temp = head;
        for (int i = 0; i < idx - 1; i++) {
          temp = temp.next;
        }
        node.next = temp.next;

        temp.next = node;
        size++;
      }
    }

    public void removeLast() {
      if (size == 0) {
        System.out.println("List is empty");
      } else if (size == 1) {
        head = tail = null;
        size = 0;
      } else {
        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
          temp = temp.next;
        }

        tail = temp;
        tail.next = null;
        size--;
      }
    }

    public void removeAt(int idx) {
      // write your code here
      if(size()==0){
          System.out.println("List is empty");
      }else if(idx<0 || idx>=size()){
          System.out.println("Invalid arguments");
      }else if(idx==0){
          removeFirst();
      }else if(idx==size-1){
          removeLast();
      }else{
          Node tmp=head;
          
          while(idx>1){
              tmp=tmp.next;
              idx--;
          }
          
          tmp.next=tmp.next.next;
        //   tmp.next.next=null;
          size--;
      }
    }
}

public class Main{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        while(!str.equals("quit!")){
            String parts[] = str.split(" ");

            switch(parts[0]){
                case "addAt" : {
                    System.out.println("addAt cmd"+parts[1]+"-->"+parts[2]);
                    list.addAt(Integer.parseInt(parts[1]) , Integer.parseInt(parts[2]));
                }break;
                case "addFirst" : {
                    System.out.println("addFirst cmd"+parts[1]);
                    list.addFirst(Integer.parseInt(parts[1]));
                }break;
                case "addLast" : {
                    System.out.println("addLast cmd"+parts[1]);
                    list.addLast(Integer.parseInt(parts[1]));
                }break;
                case "getFirst" : {
                    System.out.println("getFirst cmd");
                    System.out.println(list.getFirst());
                }break;
                case "getAt" : {
                    System.out.println("getAt cmd"+parts[1]);
                    System.out.println(list.getAt(Integer.parseInt(parts[1])));
                }break;
                case "getLast" : {
                    System.out.println("getLast cmd");
                    System.out.println(list.getLast());
                }break;
                case "removeFirst" : {
                    System.out.println("remove first");
                    System.out.println(list.getFirst());
                    list.removeFirst();
                }break;
                case "removeLast" : {
                    System.out.println("remove last");
                    System.out.println(list.getLast());
                    list.removeLast();
                }break;
                case "removeAt" : {
                    System.out.println("remove at" + parts[1]);
                    System.out.println(list.getAt(Integer.parseInt(parts[1])));
                    list.removeAt(Integer.parseInt(parts[1]));
                }break;
                case "size" : {
                    System.out.println("size : "+list.size());
                }break;
                case "display" : {
                    System.out.println("display : ");
                    list.display();
                }break;
            }
            str = scn.nextLine();
        }

    }
}