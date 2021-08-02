Cases:
1. Leaf:
2. Single child
3. 2 children


public class AVLDelete{
    public static Node deleteNode(Node node, int data){
        if(node==null){ //there is nothing to remove
            return null;
        }

        if(data<node.data){
            node.left=deleteNode(node.left, data);
        }
        else if(data>node.data){
            node.right= deleteNode(node.right, data);
        }
        else{
            if(node.left ==null && node.right==null){ //leaf node removal
                return null;
            }
            else if(node.left==null){ //single child removal, right child
                return node.right;
            }else if(node.right==null){//single child removal, left child
                return node.left;
            }
            else{ //both child exist
                int max=getMax(node.left);
                node.data=max;

                deleteNode(node.left, max);
                return node;
            }
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

    public static int getMax(Node node){
        while(node.right!=null){
            node=node.right;
        }   
        return node.data;
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