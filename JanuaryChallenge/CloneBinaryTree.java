package JanuaryChallenge;

//import javax.swing.tree.TreeNode;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(){
        left = null;
        right = null;
    }
    TreeNode(int x){
        val = x;
        left = null;
        right = null;
    }
}
public class CloneBinaryTree {
    
    private static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target){
        if(original == null) return null;
        return inorder(original,cloned,target);
    }
    private static final TreeNode inorder(final TreeNode original, final TreeNode cloned, final TreeNode target){
        if(original == target) return cloned;
        if(original.left != null){
            TreeNode leftNode = inorder(original.left, cloned.left, target);
            if(leftNode != null) return leftNode;
        }
        if(original.right != null){
            TreeNode rightNode = inorder(original.right, cloned.right, target);
            if(rightNode != null) return rightNode;
        }
        return null;
    }
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode();
        root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(19);

        TreeNode cloned = new TreeNode();
        cloned = new TreeNode(7);
        cloned.left = new TreeNode(4);
        cloned.right = new TreeNode(3);
        cloned.right.left = new TreeNode(6);
        cloned.right.right = new TreeNode(19);


        final TreeNode target = root.right;

        System.out.println(getTargetCopy(root, cloned, target).val);

    }
}
