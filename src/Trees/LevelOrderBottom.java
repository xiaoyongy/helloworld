package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {
    public LinkedList<List<Integer>> levelOrderBottom(TreeNode root){
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root==null) return result;
        q.add(root);
        while (!q.isEmpty()){
            LinkedList<Integer> res = new LinkedList<>();
            int count = q.size();
            for (int i=0;i<count;i++){
                TreeNode node = q.poll();
                res.add(node.val);
                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
            }
//            与levelOrder不同的是LinkedList的add方法使用不一样，add方法可以从尾巴添加也可以从前面添加
            result.add(0,res);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode r1 = new TreeNode(9);
        TreeNode r2 = new TreeNode(20);
        TreeNode r3 = new TreeNode(15);
        TreeNode r4 = new TreeNode(7);
        root.left = r1;
        root.right = r2;
        r2.left = r3;
        r2.right = r4;
        List result = new LevelOrderBottom().levelOrderBottom(root);
        System.out.println(result);
    }
}
