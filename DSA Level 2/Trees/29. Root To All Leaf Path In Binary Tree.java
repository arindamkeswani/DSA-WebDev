1. Given a Binary Tree, return Root to all leaf path of binary tree
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
Sample Output
4 2 1 
4 2 3 
4 6 5 
4 6 7 

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

  public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
    // write your code.
    ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> path=new ArrayList<Integer>();
    pathSumUtil(root,  path, ans);

    return ans;
  }
  
  public static void pathSumUtil(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans){
      if(root==null){
          return;
      }
      
      if(root.left==null && root.right==null){
        //   if(targetSum-root.val==0){
              ArrayList<Integer> tmp=new ArrayList<>();
              
              for(int val:path){
                  tmp.add(val);
              }
              tmp.add(root.val);
              ans.add(tmp);
        //   }
          return;
      }
      
      path.add(root.val);
      pathSumUtil(root.left, path, ans);
      pathSumUtil(root.right, path, ans);
      
      path.remove(path.size()-1); //backtrack
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

    ArrayList<ArrayList<Integer>> ans = rootToAllLeafPath(root);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> al : ans) {
      for (Integer ele : al)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}