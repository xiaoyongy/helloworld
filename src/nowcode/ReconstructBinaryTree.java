package nowcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
public class ReconstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTree1(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }
    public TreeNode reConstructBinaryTree(int[] pre, int preStart,int preEnd, int[] in, int inStart, int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==pre[preStart]){
                root.left = reConstructBinaryTree(pre, preStart+1,preStart+i-inStart,in, inStart, i-1);
                root.right = reConstructBinaryTree(pre, preStart+i-inStart+1, preEnd, in, i+1, inEnd);
                break;
            }
        }
        return root;
    }
    public List printTree(TreeNode root){
        List list = new ArrayList();
        readTree(root,list);
        return list;
    }

    public void readTree(TreeNode root, List<Integer> res){
        if (root!=null) res.add(root.val);
        assert root != null;
        if (root.left!=null) readTree(root.left,res);
        if (root.right!=null) readTree(root.right, res);
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = new ReconstructBinaryTree().reConstructBinaryTree(pre, in);
        List result = new ReconstructBinaryTree().printTree(root);
        System.out.println(result);
    }
}
