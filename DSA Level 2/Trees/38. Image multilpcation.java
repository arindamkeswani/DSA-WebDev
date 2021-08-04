You are given a binary tree. Your task is pretty straightforward. You have to find the sum of the product of each node and its mirror image (The mirror of a node is a node which exists at the mirror position of the node in opposite subtree at the root.). Don’t take into account a pair more than once. The root node is the mirror image of itself.

 


class Node{
    public int data;
    public Node left,right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
 */
 class Solution {
     static long sum=0;
    public long imgMultiply(Node root)
    {
        // code here
        if(root==null){
            return 0;
        }
        
        if(root.left!=null && root.right!=null){
            imgMultUtil(root.left,root.right);    
        }
        
        
        sum+=root.data*root.data;
        return sum%1000000007;
    }
    
    public static void imgMultUtil(Node n1, Node n2){
        if(n1==null || n2==null){
            return;
        }
        
        if(n1!=null && n2!=null){
            sum=sum+ (n1.data * n2.data);    
        }
        
        // System.out.println(n1.data+" "+n2.data);
        // System.out.println(sum);
        imgMultUtil(n1.left, n2.right);
        imgMultUtil(n1.right, n2.left);
    }
}