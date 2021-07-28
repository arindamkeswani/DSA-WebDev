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
    
    public static void printKLevelsDown(ArrayList<Integer> ans, TreeNode node, int k, TreeNode blocker) {
        if (node == null || k < 0 || node == blocker) {
            return;
        }
        if (k == 0) {
            // System.out.println(node.data);
            ans.add(node.val);
        }
        printKLevelsDown(ans,node.left, k - 1, blocker);
        printKLevelsDown(ans,node.right, k - 1, blocker);
    }
    static ArrayList<TreeNode> path;
    
  public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
    path = new ArrayList<>();
    ArrayList<Integer> ans= new ArrayList<Integer>();
    
    find(root, target); //finds path from root to node
    for (int i = 0; i < path.size(); i++) { //print all values k down of every value on root-to-node path
        printKLevelsDown(ans, path.get(i), k - i, i == 0 ? null : path.get(i - 1));
    }
    
    return ans;
  }
  
  public static boolean find(TreeNode node, int data) {
        if (node == null) {
            return false;
        }
        if (node.val == data) {
            path.add(node);
            return true;
        }
        boolean filc = find(node.left, data);
        if (filc) {
            path.add(node);
            return true;
        }
        boolean firc = find(node.right, data);
        if (firc) {
            path.add(node);
            return true;
        }
        return false;
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
    int target = scn.nextInt();
    int k = scn.nextInt();

    ArrayList<Integer> ans = distanceK(root, target, k);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.println(ele + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}