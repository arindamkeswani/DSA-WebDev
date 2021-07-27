Serialize And Deserialize Binary Tree
1. Serialization is to store tree in a file so that it can be later restored.
2. The structure of tree must be maintained. Deserialization is reading tree back from file.

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
1 -> 1 <- 1
. -> 1 <- 1
1 -> 1 <- 1
. -> 1 <- 1
. -> 1 <- .
. -> 1 <- .
. -> 1 <- .

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

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    public static void serializeHelper(TreeNode root, StringBuilder sb){
        
        if(root==null){ //no more children left, add null
            sb.append("null,");
            return;
        }
        sb.append(root.val+","); //add current node
        
        //add all children in dfs manner
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
     }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str) {
        
        String arr[] = str.split(",");
        return deserializeHelp(arr);
        
    }
    
    static int IDX=0;
    public static TreeNode deserializeHelp(String[] arr) {
        if (IDX>= arr.length || arr[IDX].equals("null")) {
            IDX++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[IDX++]));
        node.left = deserializeHelp(arr);
        node.right = deserializeHelp(arr);

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

        String s = serialize(root);
        // System.out.println(s);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}