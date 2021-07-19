1. Given a Binary Tree, print left view of it. 
2. Left view of a Binary Tree is set of nodes visible when tree is viewed from left side.
Input Format
Input is managed for you.
Output Format
Output is managed for you.
_________________________________________________
Level order traversal:
(get first element of each level. That is left view)
Make 2 queues: one for curr level, one for next level
add root to q1
add root to ans

while(q1.size()!=0 && q2.size()!=0){
    int temp=q1.poll();
    add temp to ans
    add temps children to q2;

    while(q1.size!=0){
        add all elem children in q2
    }

    Queue temp=q1;
    q1=q2;
    q2=temp;
}

return ans;

Recursive approach: O(n), sc: O(height)
public static void leftView(Node node, int level, ArrayList<Integer> ans){
    if(node==null){
        return;
    }

    if(level==ans.size()){
        ans.add(node.data);
    }
    leftView(node.left, level+1, ans);
    leftView(node.right, level+1, ans);
}

_________________________________________________
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

    public static ArrayList<Integer> leftView(TreeNode root) 
    {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<Integer> ans= new ArrayList<Integer>();
        leftView(root,0,ans);
        return ans;

    }
    
    public static void leftView(TreeNode node, int level, ArrayList<Integer> ans){
        if(node==null){
            return;
        }

        if(level==ans.size()){
            ans.add(node.val);
        }
        leftView(node.left, level+1, ans);
        
        leftView(node.right, level+1, ans);

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

        ArrayList<Integer> ans = leftView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}