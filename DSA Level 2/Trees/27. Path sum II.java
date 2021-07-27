1. You are given a partially written function to solve.
2. You are required to complete the body of PathSum function. The function is expected to return all root-to-leaf paths where each paths sum equals targetSum.
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
4
Sample Output
1 3 
_________________________
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

  public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
    ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path=new ArrayList<Integer>();
    pathSumUtil(root, targetSum, path, ans);

    return ans;
  }
  
  public static void pathSumUtil(TreeNode root, int targetSum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans){
      if(root==null){
          return;
      }
      
      if(root.left==null && root.right==null){ //at leaf node
          if(targetSum-root.val==0){ //sum is also 0, conditions match. Make new arraylist of path so far plus curr element and add to final ans
              ArrayList<Integer> tmp=new ArrayList<>(); //created for deep copy, otherwise address will be stored
              
              for(int val:path){
                  tmp.add(val);
              }
              tmp.add(root.val);
              ans.add(tmp);
          }
          return;
      }
      
      path.add(root.val);
      pathSumUtil(root.left, targetSum-root.val, path, ans);
      pathSumUtil(root.right, targetSum-root.val, path, ans);
      
      path.remove(path.size()-1); //backtrack
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
    int tar = scn.nextInt();
    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    ArrayList<ArrayList<Integer>> ans = pathSum(root, tar);
    if (ans.size() == 0) System.out.println(" ");
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}