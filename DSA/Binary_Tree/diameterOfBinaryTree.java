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

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }
    //diameter at a node= left height + right height + 2
    //height at leaves = -1
    //max height at a node = max(left tree,right tree ) + 1(including the node itself)
  static int dia=0;
  public static int diameter1(Node node) {
    // write your code here
    if(node==null){
        return -1;
    }
    int lht=diameter1(node.left);
    int rht=diameter1(node.right);
    
    if(lht+rht+2>dia){
        dia = lht+rht+2;
    }
    
    return Math.max(lht,rht)+1;
  }
//IN BELOW APPROACH DIAMETER IS ALSO RETURNED
//   public static class diasolver{
//     int ht;
//     int dia;

//     diasolver(int ht, int dia){
//         this.ht=ht;
//         this.dia=dia;
//     }
//   }

//   public static diasolver diameter2(Node node){
//     diasolver left= diameter2(node.left);
//     diasolver right= diameter2(node.right);

//     int ht = Math.max(left.ht, right.ht) + 1;
//     int dia = Math.max(left.ht+right.ht + 2, Math.max(left.dia, right.dia));

//     return new diasolver(ht,dia);
//   }

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

    Node root = construct(arr);

    // dia = 0;
    diameter1(root);
    System.out.println(dia);
  }

}