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
// this is the last time im changign it
// base cases: if one of the nodes is null, then we shoudl return the other one
// this is because even if 
// if neither nodes are null, we can actually merge by adding root 1 and 2 val together
// then if neither nodes are null, we should go and find the left and right
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root2.val += root1.val;

        root2.left = mergeTrees(root1.left, root2.left);
        root2.right = mergeTrees(root1.right, root2.right);

        return root2;
    
    }
}

// Code from my first solution - very clunky and i didn't need to do all of this
//     public void addNode(TreeNode root1, TreeNode root2){
//         if(root1 == null && root2 == null){ // check root
//             return;
//         }
//         if(root2 == null){
//             if(root1.left != null){
//                 TreeNode temp = new TreeNode(root1.left.val);
//                 root2.left = temp;
//                 addNode(root1.left, root2.left);
//             }
//             if (root1.right != null){
//                 TreeNode temp2 = new TreeNode(root1.right.val);
//                 root2.right = temp2;
//                 addNode(root1.left,root2.left);
//             }
//         } else if (root1 == null){
//             return;
//         } else { // check left and right sides
//             if(root1.left != null || root2.left != null){
//                 if(root2.left == null){
//                     TreeNode temp3 = new TreeNode(root1.left.val);
//                     root2.left = temp3;
//                 } else if (root2.left != null && root1.left != null){
//                      root2.left.val = root1.left.val + root2.left.val;
//                 } 
//             addNode(root1.left, root2.left);
//             }
//             if(root1.right != null|| root2.right != null){
//                 if (root2.right == null){
//                     TreeNode temp4 = new TreeNode(root1.right.val);
//                     root2.right = temp4; 
//                 }else if(root2.right != null && root1.right != null) {
//                     root2.right.val = root1.right.val + root2.right.val;
//             }
//             addNode(root1.right,root2.right);
//         } 
//     }
//     }
// }