1. Given a Binary Tree, return root To Node path of it. 
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
5
Sample Output
5 6 4 
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

  public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
    // write your code here
    ArrayList<TreeNode> ans=new ArrayList<TreeNode>();
    ArrayList<TreeNode> path=new ArrayList<TreeNode>();
    pathSumUtil(node, path, data, ans);
    
    return ans;
    
  }
    
    public static void pathSumUtil(TreeNode root, ArrayList<TreeNode> path, int data, ArrayList<TreeNode> ans){
      if(root==null){
          return;
      }
          
        if(root.val==data){
        //   for(TreeNode val:path){
        //       ans.add(val);
        //   }
          ans.add(root);
          for(int i=path.size()-1; i>=0;i--){
            ans.add(path.get(i));
          }
          return;
        }
        // /////////
        // for(TreeNode val:path){
        //     System.out.print(val.val+" ");
        // }
        // System.out.println();
        // /////////
          path.add(root);
          pathSumUtil(root.left, path, data, ans);
          pathSumUtil(root.right, path,data, ans);
          
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

    int data = scn.nextInt();
    ArrayList<TreeNode> ans = nodeToRootPath(root, data);
    if (ans.size() == 0)  System.out.println();
    for (TreeNode node : ans)
      System.out.print(node.val + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}