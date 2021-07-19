Level order traversal:
(get first element of each level. That is left view)
Make 2 queues: one for curr level, one for next level
add root to q1
add root to ans

while(q1.size()!=0 && q2.size()!=0){
    int temp=q1.poll();
    add temp to ans
    add temps children to q2;

    while(q1.size!=0){
        add all elem children in q2
    }

    Queue temp=q1;
    q1=q2;
    q2=temp;
}

return ans;

Recursive approach: O(n), sc: O(height)
public static void leftView(Node node, int level, ArrayList<Integer> ans){
    if(node==null){
        return;
    }

    if(level==ans.size()){
        ans.add(node.data);
    }
    leftView(node.left, level+1, ans);
    leftView(node.right, level+1, ans);
}