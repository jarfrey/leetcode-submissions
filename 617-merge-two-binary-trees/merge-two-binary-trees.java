/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null || root2 == null){
            if(root1 != null){
                TreeNode temp0 = new TreeNode(root1.val);
                root2 = temp0;
            }
            
        } else {
            root2.val = root1.val+root2.val;
        }
        
        

        addNode(root1,root2);
        return root2;
        // if not both null, add together, if 1 null, only use that, if both, ignore

    }

    public void addNode(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){ // check root
            return;
        }
        if(root2 == null){
            if(root1.left != null){
                TreeNode temp = new TreeNode(root1.left.val);
                root2.left = temp;
                addNode(root1.left, root2.left);
            }
            if (root1.right != null){
                TreeNode temp2 = new TreeNode(root1.right.val);
                root2.right = temp2;
                addNode(root1.left,root2.left);
            }
        } else if (root1 == null){
            return;
        } else { // check left and right sides
            if(root1.left != null || root2.left != null){
                if(root2.left == null){
                    TreeNode temp3 = new TreeNode(root1.left.val);
                    root2.left = temp3;
                } else if (root2.left != null && root1.left != null){
                     root2.left.val = root1.left.val + root2.left.val;
                } 
            addNode(root1.left, root2.left);
            }
            if(root1.right != null|| root2.right != null){
                if (root2.right == null){
                    TreeNode temp4 = new TreeNode(root1.right.val);
                    root2.right = temp4; 
                }else if(root2.right != null && root1.right != null) {
                    root2.right.val = root1.right.val + root2.right.val;
            }
            addNode(root1.right,root2.right);
        } 
    }
    }
}