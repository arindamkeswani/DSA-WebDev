1. Self balancing BST
2. Used to prevent skewed Binary Search Tree

Left Left problem: Tree needs to be "Right rotated". Tree is unbalanced in a left skewish way. Left subtree of left part of tree
Right right problem: Tree needs to be "Left rotated". Tree is unbalanced in a right skewish way. Right subtree of right part of tree
Left right problem: Problem is in right part of left subtree. Left rotate faulty subtree then right rotate full Tree
Right left problem: Problem is in left part of right subtree. Right rotate faulty subtree then left rotate full Tree

Tree is self-balanced in a bottom-up manner


class Solution
{
    public  Node insertToAVL(Node node,int data)
    {
        if(node == null){
            return new Node(data);
        }
 
        if(data < node.data){
            node.left = insertToAVL(node.left, data);
        }else if(node.data < data){
            node.right = insertToAVL(node.right, data);
        }
 
        int lht = height(node.left) , rht = height(node.right); 
        node.height = Math.max(lht, rht)+1; //recalculate height after insertion
        int diff = lht - rht; //calculate new difference, to chekc balancing
 
        Node newRoot = node;
        if(diff > 1){ // left tree has high number of nodes
            if(data < node.left.data){ // LL
                newRoot = rightRotate(node);
            }else if(data > node.left.data){ // LR
                node.left = leftRotate(node.left);
                newRoot = rightRotate(node);
            }
        }else if(diff < -1){ // right tree has high number of nodes
            if(data < node.right.data){ // RL
                node.right = rightRotate(node.right);
                newRoot = leftRotate(node);
            }else if(data > node.right.data){ // RR
               newRoot = leftRotate(node);
            }
        }
 
        return newRoot;
    }
 
    public int height(Node node){
        if(node == null){ 
            return 0; //as height is bode-based, not edge based
        }else{
            return node.height;
        }
    }
 
    public Node leftRotate(Node a){
        Node b = a.right; //this will be made as the new root
        Node t2 = b.left;
 
        b.left = a;
        a.right = t2;
 
        a.height = Math.max(height(a.left), height(a.right))+1;
        b.height = Math.max(height(b.left), height(b.right))+1;
        return b;
    }
 
    public Node rightRotate(Node a){
        Node b = a.left; //this will be made as the new root
        Node t2 = b.right;
 
        b.right = a;
        a.left = t2;
 
        a.height = Math.max(height(a.left), height(a.right))+1;
        b.height = Math.max(height(b.left), height(b.right))+1;
        return b;
    }
}