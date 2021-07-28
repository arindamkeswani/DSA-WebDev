Diameter Of Binary Tree All Methods

1. You are given a partially written function to solve.
2. You are required to complete the body of diameterOfBinaryTree function. The function is expected to return diameter of binary tree.
3. Input and Output is managed for you.

Sample Input
11
1
2
4
-1
-1
5
-1
-1
3
-1
-1
Sample Output
3
________________________

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
    
    
  
    
   static int ans = 0;
  public static int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return ans;
  }
  
    public static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
 
  // input_Section=================================================

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
    System.out.println(diameterOfBinaryTree(root));
  }

  public static void main(String[] args) {
    solve();
  }
}