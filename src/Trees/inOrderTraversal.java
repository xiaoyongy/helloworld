package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inOrderTraversal {
    //这是一个递归中序遍历
    public void OrderTraversal(TreeNode root, List<Integer> res){
        if (root.left!=null) OrderTraversal(root.left, res);
        res.add(root.val);
        if (root.right!=null) OrderTraversal(root.right, res);
    }
    public List<Integer> InOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root!=null) OrderTraversal(root, res);
        return res;
    }

    //一下是非递归中序遍历
    public List<Integer> InOrderTraversal2(TreeNode root){
        Stack<TreeNode> temp = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode treeNode = root;
        while(treeNode!=null||!temp.isEmpty()){
            while (treeNode!=null){
                temp.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!temp.isEmpty()){
                treeNode = temp.pop();
                res.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
        return res;
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
        List<Integer> result = new inOrderTraversal().InOrderTraversal(root);
        List<Integer> result2 = new inOrderTraversal().InOrderTraversal2(root);
        System.out.println(result);
        System.out.println(result2);
    }
}
