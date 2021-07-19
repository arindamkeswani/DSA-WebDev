
1. Given a Binary Tree, print top View of it. 
2. For more Information watch given video link below.
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
1 1 1 
_______________________________________
First element of every level in vertical order
_______________________________________
import java.util.*;

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
    
    public static class vPair {
        int hl=0;
        TreeNode node=null;
        vPair(TreeNode node,int hl)
        {
            this.hl = hl;
            this.node = node;
        }
    }
    
    public static ArrayList<Integer> TopView(TreeNode root) {
        LinkedList<vPair> que = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        
        int minhl =0;
        int maxhl =0;
        
        ArrayList<Integer> ans= new ArrayList<Integer>();
        
        
        que.addLast(new vPair(root,0));
        
        // System.out.println(que.removeFirst().node.val);
        while (que.size()!=0) {
            int size=que.size();
            
            while(size--!=0){
                vPair temp=que.removeFirst();
                
                if(map.containsKey(temp.hl)==false){
                    map.put(temp.hl, temp.node.val);
                    // map.get(temp.hl).add(temp.node.val);
                }
                // }else{
                //     map.get(temp.hl).add(temp.node.val);
                // }
                // map.putIfAbsent(temp.hl, new ArrayList<Integer>());
                
                
                maxhl=Math.max(maxhl, temp.hl);
                minhl=Math.min(minhl, temp.hl);
                
                if(temp.node.left!=null){
                    que.addLast(new vPair(temp.node.left, temp.hl-1));
                }
                
                if(temp.node.right!=null){
                    que.addLast(new vPair(temp.node.right, temp.hl+1));
                }
            }
        }
        
        for(int i=minhl; i<=maxhl; i++){
            ans.add(map.get(i));
        }
        return ans;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
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

        ArrayList<Integer> ans = TopView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}