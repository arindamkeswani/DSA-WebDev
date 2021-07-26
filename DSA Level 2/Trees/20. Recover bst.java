1. You are given a partially written function to solve(Refer question video).
2. You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.

Follow up: You are Not Allowed To Use Extra Space(Example : Storing All Element In Arrays).

Sample Input
13
7
3
2
-1
-1
10
-1
-1
5
-1
12
-1
-1
Sample Output
3 -> 7 <- 10
2 -> 3 <- 5
. -> 2 <- .
. -> 5 <- .
. -> 10 <- 12
. -> 12 <- .
__________________________________________

a,b,prev=null;
--
recoverTree(root.left);

if(prev.val < root.val ){
    prev=root;
}else{
    if(a==null){ //1st confilct
        a=prev;
    }else{ //2nd conflict
        b=root;
    }
}

If a!=null and b!=null(swap a and b)


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
    
    static TreeNode first=null;
    // TreeNode middle=null;
    static TreeNode last=null;
    static TreeNode prev=null;
    
    private static void recoverTreeUtil(TreeNode root){
        if(root!=null){
            recoverTreeUtil(root.left);

            if(prev!=null && prev.val < root.val ){
                prev=root;
            }else{
                if(first==null){ //1st confilct
                    first=prev;
                }else{ //2nd conflict
                    last=root;
                }
                
            }
            prev=root;
            
            recoverTreeUtil(root.right);
        }
        
    }
    
    public static void recoverTree(TreeNode root) {
        
        if(root==null){
            return; 
        }
        recoverTreeUtil(root);
        
        if(first!=null && last!=null){
            int temp = first.val;
            first.val = last.val;
            last.val=temp;
        }
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
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}