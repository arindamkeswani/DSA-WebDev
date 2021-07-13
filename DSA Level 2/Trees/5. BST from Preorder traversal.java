1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given PreOrder Traversal.
3. you will be given an array representing a valid PreOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
Input Format
Input is managed for you.
Output Format
Output is managed for you.


Sample Input
6
3 2 1 6 5 7
Sample Output
2 -> 3 <- 6
1 -> 2 <- .
. -> 1 <- .
5 -> 6 <- 7
. -> 5 <- .
. -> 7 <- .


________________________________________________________________________
curr value is between (left range, right range)
left call = (left range, value) | right call = (value, right range)
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

    static int bstIdx;
    
    public static TreeNode bstFromPreorder(int[] preorder) {
        bstIdx=0;
        return bstFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static TreeNode bstFromPreorder(int[] pre, int leftRange, int rightRange){
        
        if(bstIdx>=pre.length || pre[bstIdx]<leftRange || pre[bstIdx]>rightRange){
            return null;
        }
        TreeNode node = new TreeNode(pre[bstIdx++]);
        node.left = bstFromPreorder(pre, leftRange, node.val);
        node.right = bstFromPreorder(pre, node.val,rightRange );
        return node;
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}