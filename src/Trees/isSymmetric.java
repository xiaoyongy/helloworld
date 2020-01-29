package Trees;

public class isSymmetric {
    public boolean isSym(TreeNode r1, TreeNode r2){
        if (r1==null&&r2==null) return true;
        if (r1==null||r2==null) return false;
        return r1.val==r2.val&&isSym(r1.left,r2.right)&&isSym(r1.right,r2.left);
    }
    public boolean isSymmetric(TreeNode root){
        if (root==null) return true;
        return isSym(root.left,root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(4);
        TreeNode r6 = new TreeNode(3);
        root.left = r1;
        root.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.left = r5;
        r2.right = r6;
        boolean flash = new isSymmetric().isSymmetric(root);
        System.out.println(flash);
    }
}
