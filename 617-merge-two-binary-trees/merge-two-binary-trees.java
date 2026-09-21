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
//I did this problem twice. The first time, in lab, I did it not very well 
// so I redid it before I looked at the solutions
// Both of them have the same idea: use recursion to merge trees.
// How it works is it first checks if both pointers are null. If they are there's no point
// continuing so it goes back (base case)
// If only 1 is null, then we just set the output tree to the one non-null
// In this case tree 2 is our output so if 1 is non-null, 2 gets a new node from 1
// If 1 is null we lowkey don't care since 2 has it. If statements are structured like that
// so it makes more sense to read
// Anyway if 1 is non-null we gotta check if there's more from 1 that aren't null so we check
// left and right children
//Otherwise, if both left and right node exist, EZPZ we just combine them
// then obv we go and look for their left and right children
// we then return tree2, which will (after all of this) contain the merged tree.
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null || root2 == null){
            if(root1 != null){
                TreeNode temp0 = new TreeNode(root1.val);
                root2 = temp0;
                root2.left = mergeTrees(root1.left, root2.left);
                root2.right = mergeTrees(root1.right, root2.right);
            }

        } else {
            root2.val = root1.val+root2.val;
            root2.left = mergeTrees(root1.left, root2.left);
            root2.right = mergeTrees(root1.right, root2.right);
        }

        return root2;
        
        // addNode(root1,root2);
        // return root2;
        // if not both null, add together, if 1 null, only use that, if both, ignore

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