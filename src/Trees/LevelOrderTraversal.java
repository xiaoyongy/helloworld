package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root==null) return list;
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int size = q.size();
            for (int i=0;i<size;i++){
                TreeNode res = (TreeNode)q.poll();
                list1.add(res.val);
                if (res.left!=null){
                    q.add(res.left);
                }
                if (res.right!=null){
                    q.add(res.right);
                }

            }
            list.add(list1);
        }
        return list;
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
        List result = new LevelOrderTraversal().levelOrder(root);
        System.out.println(result);
    }
}