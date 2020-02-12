package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preOrderTraversal(TreeNode node){
        if (node==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.left!=null){
                preOrderTraversal(temp.left);
            }else {
                continue;
            }
            if (temp.right!=null){
                preOrderTraversal(temp.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(6);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(8);
        root.left = r1;
        root.right = r2;
        r2.left = r3;
        r2.right = r4;
        List result = new PreOrderTraversal().preOrderTraversal(root);
        System.out.println(result);
    }
}
