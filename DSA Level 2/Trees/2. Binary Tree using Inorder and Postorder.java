1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PostOrder and InOrder Traversal.
3. you will be given two arrays representing a valid PostOrder & InOrder of a Binary Tree. Program is required to create a unique Binary Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 

Sample Input
7
1 3 2 5 7 6 4
1 2 3 4 5 6 7
Sample Output
2 -> 4 <- 6
1 -> 2 <- 3
. -> 1 <- .
. -> 3 <- .
5 -> 6 <- 7
. -> 5 <- .
. -> 7 <- .


________________________________________________________________________
private static TreeNode buildTree (int postorder[], int psi, int pei, int inorder[], int isi, int iei){
    if(psi>pei){
        return null;
    }

    int val= postorder[pei];  //current element to work on in preorder list
    int idx = isi; 

    //get same element in order list
    while(inorder[idx]!=val){
        idx++; //this gives current elelment to work on (from inorder list)
    }
    int tnel = idx-isi; //total no of elem in subtree
    //first tnel elem in postorder list will be left subtree, then next tnel no after that will be right subtree, followed by root
    //left: psi to psi+tnel-1
    //right:psi+tnel to pei-1

    TreeNode node= new TreeNode(val);
    node.left=buildTree(postorder, psi, psi+tnel-1, inorder, isi, idx-1);
    node.right=buildTree(postorder, psi+tnel, pei-1, inorder, idx+1, iei);

    return node;
}

return buildTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);

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
    
    private static TreeNode buildTree (int postorder[], int psi, int pei, int inorder[], int isi, int iei){
        if(psi>pei){
            return null;
        }
    
        int val= postorder[pei];  //current element to work on in preorder list
        int idx = isi; 
    
        //get same element in order list
        while(inorder[idx]!=val){
            idx++; //this gives current elelment to work on (from inorder list)
        }
        int tnel = idx-isi; //total no of elem in subtree
        //first tnel elem in postorder list will be left subtree, then next tnel no after that will be right subtree, followed by root
        //left: psi to psi+tnel-1
        //right:psi+tnel to pei
    
        TreeNode node= new TreeNode(val);
        node.left=buildTree(postorder, psi, psi+tnel-1, inorder, isi, idx-1);
        node.right=buildTree(postorder, psi+tnel, pei-1, inorder, idx+1, iei);
    
        return node;
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}