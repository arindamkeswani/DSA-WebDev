1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PreOrder and PostOrder Traversal.
3. you will be given two arrays representing a valid PostOrder & PreOrder of a Binary Tree. Program is required to create a unique Binary Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you.

Sample Input
7
1 3 2 5 7 6 4
4 2 1 3 6 5 7
Sample Output
2 -> 4 <- 6
1 -> 2 <- 3
. -> 1 <- .
. -> 3 <- .
5 -> 6 <- 7
. -> 5 <- .
. -> 7 <- .

________________________________________________________________________


value of current node = postorder[postOrderEndIndex]
(or preorder[preOrderStartingIndex])

total no of elements = idx - PostOrderStartingIndex + 1;


________________________________________________________________________

import java.util.Scanner;

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
    
        
    public static TreeNode constructFromPrePost(int[] pre, int prsi, int prei, int[] post, int posi, int poei){
        
        if(prsi>prei){
            return null;    
        }
        
        int val= post[poei];
        TreeNode node = new TreeNode(val);
        
        if(prsi==prei){
            return node;
        }
        int idx = posi;
        while(post[idx] != pre[prsi+1]){
            idx++;
        }
        
        int tnel = idx-posi+1;
        
        node.left=constructFromPrePost(pre, prsi+1,prsi +tnel,post, posi, idx);
        node.right=constructFromPrePost(pre, prsi+tnel+1,prei,post, idx+1,poei-1);
        
        return node;
    }
    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, 0, pre.length-1, post, 0, post.length-1);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}