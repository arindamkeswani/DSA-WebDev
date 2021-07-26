1. You are given a partially written function to solve.
2. Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
    a. Choose any node in the binary tree and a direction (right or left).
    b. If the current direction is right then move to the right child of the current node otherwise move to the left child.
    c. Change the direction from right to left or right to left.
    d. Repeat the second and third step until you cant move in the tree.

3.Zigzag length is defined in terms of edges. (A single node has a length of 0).
4. Return the longest ZigZag path contained in that tree.

Sample Input
15
1
1
-1
1
1
-1
1
-1
-1
1
-1
-1
1
-1
-1
Sample Output
4
__________________________________________

Not necessary that longest path is from root

backwardzigzagPathLength of node= forwardzpl of lChild + 1
forwardzigzagPathLength of node= backwardzpl of rchild + 1

ans=Math.max(bzpl of lCHild, backwardzigzagPathLength of node , fzpl of right child , forwardzigzagPathLength of node)

__________________________________________

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
    
    public static class pair{
        int forwardSlope = -1;
        int backwardSlope = -1;
        int maxLen=0;
    }
    
    public static pair util(TreeNode node){
        if(node==null){
            return new pair();
        }
        
        pair left = util(node.left);
        pair right = util(node.right);
        
        pair ans=new pair();
        
        ans.maxLen =Math.max( Math.max(right.maxLen, left.maxLen) , Math.max(left.forwardSlope + 1, right.backwardSlope+1) );
        
        ans.forwardSlope = right.backwardSlope+1;
        ans.backwardSlope = left.forwardSlope+1;
        return ans;
    }
    
    public static int longestZigZagPath(TreeNode root) {
        pair ans=util(root);
        return ans.maxLen;
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}