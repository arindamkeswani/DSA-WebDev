1. You are given a partially written function to solve.
2. You are required to complete the body of maxPathSum function. The function is expected to return Integer value depending upon maximum leaf-to-leaf paths sum.
3. Input and Output is managed for you.

Sample Input
7
1
2
-1
-1
3
-1
-1
Sample Output
6
________________________
Heap mover approach

Find max sum till leaf in left and right subtrees
add root value to it
return it up the tree

Node-> left.LeafToLeafMaxSum + right.LeafToLeafMaxSum + node.val;


public class Pair{
    int NTLMS, int LTLMS
    Pair(int a, int b){
        NTLMS=a;
        LTLMS=b;
    }
}

public static int maxPathSum(TreeNode root) {
    return maxPathSumHelper(TreeNode root).LTLMS;
}

public static Paur maxPathSumHelper(TreeNode root){
    if(node==null){
        return new Pair(0,0);
    }

    Pair lPair=maxPathSumHelper(node.left);
    Pair rPair=maxPathSumHelper(node.right);

    int NTLMS = Math.max(lPair.NTLMS, rPair.NTLMS) + root.val;
    int LTLMS= Math.max(lPair.LTLMS, rPair.LTLMS);
    if(node.left!=null && node.right!=null){
        LTLMS = Math.max(LTLMS, lPair.NTLMS + root.val + rPair.NTLMS);
    }
    return new Pair(NTLMS, LTLMS);
}


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

    static int LTLMaxSum;
  public static int maxPathSum(TreeNode root) {
    LTLMaxSum=Integer.MIN_VALUE; //so as to not ignore negative sum values
    maxPathSumHelper(root);
    return LTLMaxSum;
  }

    public static int maxPathSumHelper(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftNTLMaxSum=maxPathSumHelper(root.left); //node to leaf sum left
        int rightNTLMaxSum=maxPathSumHelper(root.right); //node to leaf sum right
        if(root.left!=null && root.right!=null){ //to check if 2 leaves exists for a valid option, as sum can only exists if there are 2 leaves for a "leaf to leaf sum"
            LTLMaxSum = Math.max(LTLMaxSum, leftNTLMaxSum + root.val + rightNTLMaxSum);    
        }
        return Math.max(leftNTLMaxSum, rightNTLMaxSum) + root.val; //push it up the branches
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
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}