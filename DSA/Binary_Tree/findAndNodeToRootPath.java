// 1. You are given a partially written BinaryTree class.
// 2. You are given an element.
// 3. You are required to complete the body of find and nodeToRoot function. The functions are expected to 
//     3.1. find -> return true or false depending on if the data is found in binary tree.
//     3.2. nodeToRoot -> returns the path from node (correspoding to data) to root in 
//     form of an arraylist (root being the last element)
// 4. Input iand Output is managed for you.


import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static boolean find(Node node, int val){
    // write your code here
    if(node==null){
        return false;
    }
    if(node.data==val){ //check current node
        return true;
    }
    if(find(node.left,val)){ //check left sub-tree
        return true;
    }
    if(find(node.right,val)){ //check right sub-tree
        return true;
    }

    return false;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int val){
    // write your code here
    //Empty arraylist returned = Element not found/unsuccessful attempt

    if(node==null){
        return new ArrayList<Integer>();
    }
    if(node.data==val){ //check current node
        ArrayList<Integer> res= new ArrayList<Integer>();
        res.add(val);
        return res;
    }

    ArrayList<Integer> Lres = nodeToRootPath(node.left , val); //store left recursive result
    if(Lres.size()>0){ //if there is any entry in the ArrayList that has been returned, condition true
        Lres.add(node.data);
        return Lres;
    }

    ArrayList<Integer> Rres = nodeToRootPath(node.right , val);
    if(Rres.size()>0){
        Rres.add(node.data);
        return Rres;
    }

    return new ArrayList<Integer>();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    boolean found = find(root, data);
    System.out.println(found);

    ArrayList<Integer> path = nodeToRootPath(root, data);
    System.out.println(path);
  }

}