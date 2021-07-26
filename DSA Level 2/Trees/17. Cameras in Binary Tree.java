1. You are given a partially written function to solve.
2. You are required to complete the body of MinCamerasInBT_ function. The function is expected to return integer value representing minimum number of camera(s) required for the coverage of complete tree.
3.A camera is placed on any node will ensure coverage of parent-node as well as its child-node(s), if any.
4. Input and Output is managed for you.

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
3
__________________________________________
Cases:
1. Camera is placed on the node
2. Camera is not placed on node:
Point 2. branches into 2 conditions
    2.1. Node is covered by another Camera
    2.2. Node needs to be covered

-1:Camera needed
0: Camera planted
1: Area covered

Work is done in postorder

// if(both childred==0 || 1){
//     node=1;
// }
if leftChild==-1 || rightChild==-1{ //requirement
    
    camera++;
    return 0;
}
if(rChild==0 || lChild==0){ //covered
    return 1;
}

return -1;//leaf node of both chlidren are already covered, camera needed

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
    
    static int camera=0;
    public static int MinCamerasInBT(TreeNode root) {
        camera=0;
        if(MinCamerasInBTHelper(root)==-1){
            camera++;
        }
        return camera;
    }
    
    private static int MinCamerasInBTHelper(TreeNode root){
        if(root==null){
            return 1;
        }
        
        int leftState = MinCamerasInBTHelper(root.left);
        int rightState = MinCamerasInBTHelper(root.right);
        
        if(leftState==-1 || rightState==-1){
            camera++;
            return 0;
        }
        if(leftState==0 || rightState==0){
            
            return 1;
        }
        return -1;
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
        System.out.println(MinCamerasInBT(root));

    }

    public static void main(String[] args) {
        solve();
    }
}