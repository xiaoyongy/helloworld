package Trees;

public class IsBanlancedTree {
    private boolean isBanlanced = true;
    public int getDepth(TreeNode root){
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left-right)>1) isBanlanced = false;
        return Math.max(left,right)+1;
    }
    public boolean isBanlanced(TreeNode root){
        getDepth(root);
        return isBanlanced;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;
        boolean flash = new IsBanlancedTree().isBanlanced(root);
        System.out.println(flash);
    }
}
