_______________________________________
public static void rightView(Node node, int level, ArrayList<Integer> ans){
    if(node==null){
        return;
    }

    if(level==ans.size()){
        ans.add(node.data);
    }
    rightView(node.right, level+1, ans);
    rightView(node.left, level+1, ans);
    
}

_______________________________________
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

    public static ArrayList<Integer> rightView(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> ans= new ArrayList<Integer>();
        rightView(root,0,ans);
        return ans;

    }
    
    public static void rightView(TreeNode node, int level, ArrayList<Integer> ans){
        if(node==null){
            return;
        }

        if(level==ans.size()){
            ans.add(node.val);
        }
        rightView(node.right, level+1, ans);
        rightView(node.left, level+1, ans);

    }

    // input_section=================================================

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

        ArrayList<Integer> ans = rightView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}