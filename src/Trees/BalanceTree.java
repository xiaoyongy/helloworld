package Trees;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
public class BalanceTree {

    /*方式二：从下往上遍历
    * 这样每个节点高度只会算一次
    * */
    public boolean IsBalanceTree(TreeNode node){
        int depth = Depth(node);
        return depth != 0;
    }

    public int Depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Depth(node.left);
        int right = Depth(node.right);
        if(Math.abs(left-right)>1){
            return 0;
        }
        return Math.max(left, right)+1;
    }
}
