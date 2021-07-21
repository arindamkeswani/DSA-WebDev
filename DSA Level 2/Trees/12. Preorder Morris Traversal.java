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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        
        while(root!=null){
            if(root.left==null){
                // System.out.println(root.val);
                ans.add(root.val);
                root=root.right;
            }
            else{
                TreeNode rootp1=root.left;
                
                while(rootp1.right!=null && rootp1.right!=root){
                    rootp1=rootp1.right;
                }
                if(rootp1.right==null){ //1st visit
                    // System.out.println(root.val);
                    ans.add(root.val);
                    rootp1.right=root; //form connection
                    root=root.left;
                }
                else{ //2nd visit, left is already traversed
                    rootp1.right=null; //break connection
                    root=root.right;
                }
            }
        }
        return ans;
    }
}