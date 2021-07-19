public static void rightView(Node node, int level, ArrayList<Integer> ans){
    if(node==null){
        return;
    }

    if(level==ans.size()){
        ans.add(node.data);
    }
    rightView(node.right, level+1, ans);
    rightView(node.left, level+1, ans);
    
}