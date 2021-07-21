class Solution
{
    void printLeaves(Node node, ArrayList <Integer> ans)
    {
        if (node == null)
            return;

        printLeaves(node.left, ans);
        // Print it if it is a leaf node
        if (node.left == null && node.right == null)
            ans.add(node.data);
        printLeaves(node.right, ans);
    }
    
    void printBoundaryLeft(Node node, ArrayList <Integer> ans)
    {
        if (node == null)
            return;

        if (node.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            ans.add(node.data);
            printBoundaryLeft(node.left, ans);
        }
        else if (node.right != null) {
            ans.add(node.data);
            printBoundaryLeft(node.right, ans);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }
    
    void printBoundaryRight(Node node, ArrayList <Integer> ans)
    {
        if (node == null)
            return;

        if (node.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.right, ans);
            ans.add(node.data);
        }
        else if (node.left != null) {
            printBoundaryRight(node.left, ans);
            ans.add(node.data);
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }
    
	ArrayList <Integer> printBoundary(Node node)
	{
	    ArrayList <Integer> ans= new ArrayList <Integer>();
	    
	    if (node == null)
            return new ArrayList<Integer>();

        ans.add(node.data);

        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.left, ans);

        // Print all leaf nodes
        printLeaves(node.left, ans);
        printLeaves(node.right, ans);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.right, ans);
        
        return ans;
	}
}
