A binary tree is just like a generic tree that limits the number of children it has to 2
These are represented as right and left child
If a node does not have a child, then null needs to be assigned to that child
To pass values such as null as part of the array of values in a binary tree, use Integer type array instead of int


//Binary tree construction
import java.util.Stack;
public class Main{
    public static class Node{
        int data;
        Node left;
        Node right;
       
        Node(int data){
            this.data = data;
        }
    }    
   
    public static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public static Node construct(Integer input[]){
        Stack<Pair> st = new Stack<>();
        Node root = new Node(input[0]);
        st.push(new Pair(root,1));
        int idx = 1;
        while(st.size() > 0){
            Pair top = st.peek();
            if(top.state == 1){
                Integer val = input[idx++];
                if(val == null){
                    top.state++;
                }else{
                    Node newNode = new Node(val);
                    top.node.left = newNode;
                    top.state++;
                    st.push(new Pair(newNode,1));
                }
            }else if(top.state == 2){
                Integer val = input[idx++];
                if(val == null){
                    top.state++;
                }else{
                    Node newNode = new Node(val);
                    top.node.right = newNode;
                    top.state++;
                    st.push(new Pair(newNode,1));
                }
            }else if(top.state == 3){
                st.pop();
            }
        }
        return root;
    }
   
    public static void display(Node node){
        if(node == null){
            return;
        }
        String str = node.left == null ? "." : node.left.data+"";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data+"";
        System.out.println(str);
       
        display(node.left);
        display(node.right);
    }
   
    public static void main(String args[]){
        Integer input[] = {10,20,40,null,null,50,80,null,null,null,30,60,null,90,null,null,70,null,null};
        Node root = construct(input);
        display(root);
    }
}