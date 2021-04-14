// 1. You are given a partially written GenericTree class.
// 2. You are require to complete the body of function IterativePreandPostOrder. The function does not use recursion and prints preorder and postorder of the tree. Both orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order are separated by space.
// 3. Input and Output is managed for you.


import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
    
    
  public static class traversalSolver{
      int state;
      Node node;
      
      traversalSolver(Node node){
          this.node=node;
          this.state=-1;
      }
  }
  public static void IterativePreandPostOrder(Node root) {
    // write your code here
    Stack<traversalSolver> st= new Stack<>();
    st.push(new traversalSolver(root));
    String pre="",post="";
    while(st.size()>0){
        traversalSolver topPair = st.peek();
        if(topPair.state==-1){
            //preorder
            pre+=topPair.node.data+" ";
            topPair.state++;
        }else if(topPair.state==topPair.node.children.size()){
            //postorder
            post+=topPair.node.data+" ";
            st.pop();
        }else{
            st.push(new traversalSolver(topPair.node.children.get(topPair.state++)));
        }
    }
    
    System.out.println(pre);
    System.out.println(post);
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    IterativePreandPostOrder(root);
  }

}