left tail effort
no  no      no
yes no      yes
no  yes     no //as it is already in place
yes yes     yes



leftTail=flatten(root.left);
rightTail=flatten(root.right);

leftTail.right=root.right; //connect leftsubtree to right subtree (both flattened)
root.right=root.left; //add left subtree to right of root
root.left=null; //remove connections to the left



_____

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        // flattenUtil(root);
        
        if(root==null || (root.left==null && root.right==null)){ //no work to be done here
            return;
        }
        
        if(root.left!=null){
            flatten(root.left);
            
            //make left subtree as right child
            TreeNode temp = root.right;
            root.right=root.left;
            root.left = null;

            //get tail node of left subtree
            TreeNode t = root.right;
            
            while(t.right!=null){
                t = t.right;
            }
            
            //attach tail of left subtree to right subtree
            t.right = temp;
        }
         
        //flatten right subtree
        flatten(root.right);
    }
    
//     public static TreeNode flattenUtil(TreeNode root){
//         if(root==null){
//             return null;
//         }
//         TreeNode leftTail=flattenUtil(root.left);
//         TreeNode rightTail=flattenUtil(root.right);
        
//         if(root.left==null && root.right==null){
//             return null;
//         }
        
//         if(root.left!=null && root.right==null){
//             root.right=root.left; //add left subtree to right of root
//             root.left=null; //remove connections to the left
//         }
//         if(root.left!=null && root.right!=null){
//             leftTail.right=root.right; //connect leftsubtree to right subtree (both flattened)
//             root.right=root.left; //add left subtree to right of root
//             root.left=null; //remove connections to the left
//         }
        
//         return rightTail;
//     }
}