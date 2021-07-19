1. Given a Binary Tree, print Vertical Order of it. 
2. For more Information watch given video link below.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
_______________________________________
go towards left and keep decrementing -1
go towards right and keep incrementing 1

All vertical levels have same value
Hashmap<Integer, ArrayList<Integer>> hm = newHashMap<>();

keep adding entries of node.data in their respective level in hm

DFS gives wrong order
BFS (level order) gives correct order

Make 2 queues, curr and next
_______________________________________

import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class vPair {
        int hl=0;
        TreeNode node=null;
        vPair(TreeNode node,int hl)
        {
            this.hl = hl;
            this.node = node;
        }
    }
    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        // if (root == null)
        //     return new ArrayList<ArrayList<Integer>>();
        LinkedList<vPair> que = new LinkedList<>(); //LL to store elements in current horizontal  level
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>(); //to store vertical level wise elements
        
        
        int minhl =0; //lowest vert level
        int maxhl =0; //highest vert level from root
        
        ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>(); //store final ans
        
        
        que.addLast(new vPair(root,0));
        
        // System.out.println(que.removeFirst().node.val);
        while (que.size()!=0) {
            int size=que.size();
            
            while(size--!=0){
                vPair temp=que.removeFirst();
                
                if(map.containsKey(temp.hl)==false){
                    map.put(temp.hl, new ArrayList<Integer>());
                    map.get(temp.hl).add(temp.node.val);
                }else{
                    map.get(temp.hl).add(temp.node.val);
                }
                // map.putIfAbsent(temp.hl, new ArrayList<Integer>());
                
                
                maxhl=Math.max(maxhl, temp.hl);
                minhl=Math.min(minhl, temp.hl);
                
                if(temp.node.left!=null){
                    que.addLast(new vPair(temp.node.left, temp.hl-1)); //add left node to queue
                }
                
                if(temp.node.right!=null){
                    que.addLast(new vPair(temp.node.right, temp.hl+1)); //add right node to queue
                }
            }
        }
        
        for(int i=minhl; i<=maxhl; i++){
            ans.add(map.get(i));
        }
        return ans;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}