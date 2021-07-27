1. Given a Binary Tree, return list of all single child parent of binary tree
2. For more Information watch given video link below.

Sample Input
15
4
2
1
-1
-1
3
-1
-1
6
5
-1
-1
7
-1
-1
_______________________________

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

  public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
    ArrayList<Integer> ans = new ArrayList<>();
    util(root, ans);
    return ans;
  }
  
  public static void util(TreeNode root, ArrayList<Integer> ans){
    if(root==null || (root.left==null && root.right==null)){ //leaf node
        return; 
    }
    if(root.left==null || root.right==null){ //root has only one child
        ans.add(root.val);
    }
    util(root.left, ans);
    util(root.right, ans);
    
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);

    ArrayList<Integer> ans = exactlyOneChild(root);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.print(ele + " ");
  }

  public static void main(String[] args) {
    solve();
  }
}