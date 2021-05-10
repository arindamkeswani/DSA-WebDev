Binary Tree Ultimate
// 1. An input for Binary tree(as discussed in the class);
// 2. Code is expected to
//    2.1 contruct and display a Binary Tree.
//    2.2 Complete structures for Max , Min ,  Sum , Size ,  Ht , find , nodeToRootPath in a binary tree.
// Note : Input/Output is already handled for you.

//Complete Solution
import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left , right;
    Node(int data){
        System.out.println("Node created");
        this.data = data;
    }

    Node(int data , Node left , Node right){
        this(data);
        this.left = left;
        this.right = right;
    }
}
class BT{
    Node root; 
    BT(Integer inp[]){
        System.out.println("Constructing your binary Tree");
        root = construct(inp);
    }
    private static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.state = state;
            this.node = node;
        }
    }
    private Node construct(Integer inp[]){
      // code for contructing binary tree
        Node root = new Node(inp[0], null, null);
        Pair rtp = new Pair(root,1);
        
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
        
        int idx =0;
        while(st.size()>0){
            Pair top= st.peek();
            if(top.state == 1){
                idx++;
                if(inp[idx]!=null){
                    top.node.left = new Node(inp[idx],null,null);
                    Pair lp = new Pair(top.node.left,1);
                    st.push(lp);
                }
                else{
                    top.node.left = null;
                }
                top.state++;
            }
            else if(top.state == 2){
                idx++;
                if(inp[idx]!=null){
                    top.node.right = new Node(inp[idx],null,null);
                    Pair rp = new Pair(top.node.right,1);
                    st.push(rp);
                }
                else{
                    top.node.right = null;
                }
                top.state++;
            }
            else{
                st.pop();
            }
            
        }
        return root;
    }
    public void display(){
        display(root);
    }
    public int size(){
        return size(root);
    }
    public int sum(){
        return sum(root);
    }
    public int max(){
        return max(root);
    }
    public int min(){
        return min(root);
    }
    public int height(){
        return height(root);
    }
    public boolean find(int data){
        return find(root,data);
    }
    public ArrayList<Integer> nodeToRootPath(int data){
        return nodeToRootPath(root,data);
    }
    private void display(Node node) {
        // code for displaying binary tree
         if(node == null){
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

    private int size(Node node) {
        // code for finding size of binary tree
        if(node ==null){
            return 0;
        }

        int lSize = size(node.left);
        int rSize = size(node.right);

        return lSize+rSize+1;
    }
  
    private int sum(Node node) {
        // code for finding sum of binary tree
        if(node ==null){
            return 0;
        }

        int lSum = sum(node.left);
        int rSum = sum(node.right);
    
    return lSum + rSum + node.data;
    }
  
    private int max(Node node) {
        // code for finding max of binary tree
        if(node ==null){
            return Integer.MIN_VALUE;
        }

        int lMax = max(node.left);
        int rMax = max(node.right);
    
        return Math.max(node.data , Math.max(lMax,rMax));
    }
    private int min(Node node) {
        // code for finding min of binary tree
        if(node ==null){
            return Integer.MAX_VALUE;
        }

        int lMin = min(node.left);
        int rMin = min(node.right);
    
        return Math.min(node.data , Math.min(lMin,rMin));
    }
    
    private int height(Node node) {
        // code for finding height of binary tree
        if(node==null){
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        
        return Math.max(lh,rh)+1;
    }

    private boolean find(Node node, int val){
        // code for finding data in a binary tree
        if(node==null){
            return false;
        }
        
        if(node.data==val){
            return true;
        }
        if(find(node.left,val)){
            return true;
        }
        if(find(node.right,val)){
            return true;
        }
        
        return false;
    }
    
    private ArrayList<Integer> nodeToRootPath(Node node, int val){
        // code for nodeToRootPath in a binary tree
        if(node==null){
            return new ArrayList<Integer>();
        }
        if(node.data==val){
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(val);
            return res;
        }
        
        ArrayList<Integer> Lres = nodeToRootPath(node.left, val);
        if(Lres.size()>0){
            Lres.add(node.data);
            return Lres;
        }
        ArrayList<Integer> Rres = nodeToRootPath(node.right, val);
        if(Rres.size()>0){
            Rres.add(node.data);
            return Rres;
        }
        return new ArrayList<Integer>();
    }

}

public class Solution{
    public static void main(String[] args) throws Exception{
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
        BT bt = new BT(arr);

        bt.display();
        System.out.println("Size " + bt.size());
        System.out.println("Sum "+bt.sum());
        System.out.println("Max "+bt.max());
        System.out.println("Min "+bt.min());
        System.out.println("Height "+bt.height());

        boolean found = bt.find(data);
        System.out.println(found);

        ArrayList<Integer> path = bt.nodeToRootPath(data);
        System.out.println(path);
    }
}

/////////////////////////////////////////////////////////////
Generic Tree Ultimate
// 1. An input for Generic tree(as discussed in the class);
// 2. Code is expected to
//    2.1 contruct and display a Generic Tree.
//    2.2 Complete structures for Max , Min ,  Sum , Size ,  Ht , find , nodeToRootPath in a generic tree.
// Note : Input/Output is already handled for you.



//Partial Solution

import java.util.*;
import java.io.*;
class Node{
    int data;
    ArrayList<Node> children = new ArrayList<>();
    Node(int data){
        System.out.println("Node created");
        this.data = data;
    }
}
class GT{
    Node root; 
    GT(Integer inp[]){
        System.out.println("Constructing your generic Tree");
        root = construct(inp);
    }
    private static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.state = state;
            this.node = node;
        }
    }
    private Node construct(Integer inp[]){
      // code for contructing Generic tree
    }
    public void display(){
        display(root);
    }
    public int size(){
        return size(root);
    }
    public int sum(){
        return sum(root);
    }
    public int max(){
        return max(root);
    }
    public int min(){
        return min(root);
    }
    public int height(){
        return height(root);
    }
    public boolean find(int data){
        return find(root,data);
    }
    public ArrayList<Integer> nodeToRootPath(int data){
        return nodeToRootPath(root,data);
    }
    private void display(Node node) {
        // code for displaying Generic tree
    }

    private int size(Node node) {
        // code for finding size of Generic tree
    }
  
    private int sum(Node node) {
        // code for finding sum of Generic tree
    }
  
    private int max(Node node) {
        // code for finding max of Generic tree
    }
    private int min(Node node) {
        // code for finding min of Generic tree
    }
    
    private int height(Node node) {
        // code for finding height of Generic tree
    }

    private boolean find(Node node, int data){
        // code for finding data in a Generic tree
    }
    
    private ArrayList<Integer> nodeToRootPath(Node node, int data){
        // code for nodeToRootPath in a Generic tree
    }

}

public class Solution{
    public static void main(String[] args) throws Exception{
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
        GT gt = new GT(arr);

        bt.display();
        System.out.println("Size " + gt.size());
        System.out.println("Sum "+gt.sum());
        System.out.println("Max "+gt.max());
        System.out.println("Min "+gt.min());
        System.out.println("Height "+gt.height());

        boolean found = gt.find(data);
        System.out.println(found);

        ArrayList<Integer> path = gt.nodeToRootPath(data);
        System.out.println(path);
    }
}