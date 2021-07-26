1. You are given a partially written function to solve.
2. The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting the police.
3. Input and Output is managed for you.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 

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
4
__________________________________________
If node==null{
    return 0;
}
1. Check profit of stealing from node
    1.1. MAX(leftChilds testing (no robbery) + rightChilds testing(no robbery) + node.val)
2. Check profit of not stealing from node
    2.1. MAX(Check profit of stealing from leftChild vs not stealing from leftChild)
    2.2. MAX(Check profit of stealing from rightChild vs not stealing from rightChild)
    Add 2.1 and 2.2


Below implementation is using classes, it can also be done using array of size 2 (with and without robbery)
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
    
    public static class HRPair{
        int withRobbery;
        int withoutRobbery;
        HRPair(int with, int without){
            this.withRobbery=with;
            this.withoutRobbery=without;
        }
    }
    
    private static HRPair HouseRobberUtil(TreeNode root){
        if(root==null){
            return new HRPair(0,0);
        }
        
        HRPair lChild= HouseRobberUtil(root.left);
        HRPair rChild= HouseRobberUtil(root.right);
        int withRobbery= root.val + lChild.withoutRobbery + rChild.withoutRobbery;
        int withoutRobbery = Math.max(lChild.withoutRobbery , lChild.withRobbery) + Math.max(rChild.withoutRobbery , rChild.withRobbery);
        
        return new HRPair(withRobbery, withoutRobbery);
    }
    public static int HouseRobber(TreeNode root) {
        HRPair res = HouseRobberUtil(root);
        return Math.max(res.withRobbery , res.withoutRobbery);
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}