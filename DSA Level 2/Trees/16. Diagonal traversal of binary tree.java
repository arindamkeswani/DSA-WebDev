Reduce level by 1 when processing left child
retain same level for right child
___
class Tree
{
    

     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           ArrayList<Integer> ans=new ArrayList<Integer>();
           
            if (root == null)
            {
                return new ArrayList<Integer>();
            }
            
            Queue<Node> q = new LinkedList<Node>();
            
            q.add(root);
            
            
            while(q.isEmpty()==false){
                Node curr=q.remove();
                // ans.add(curr.data);
                
                while(curr!=null){
                    ans.add(curr.data);
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    curr=curr.right;
                    
                }
                
            }
            
            return ans;
      }
}
