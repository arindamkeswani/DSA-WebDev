lHead=fun(root.left);
rHead=fun(root.right);

--//2 child
lTail=lHead.left;
lTail.right=root;
root.left=lTail;
rTail=rHead.left;

rHead.left=root;
rTail.right=lHead;
lHead.left=rTail;

return lHead;
--

//only right child
lHead=fn(root.left);
rHead=fn(root.right);

rTail=rHead.right;
root.right=rHead;

