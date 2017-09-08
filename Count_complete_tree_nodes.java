/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        TreeNode temp=root, ltemp, mtemp, rtemp;
        if (root==null) return 0; else if (root.left==null) return 1;
        int sum;
        int h=0;
        while (temp.left!=null) {
            h++;
            temp=temp.left;
        }
        
        sum=(1<<h)-1;
        temp=root;
        //int h1=h;
        for (int h1=h; h1>=1; h1--) {
            ltemp=temp.left;
            rtemp=temp.right;
            mtemp=temp.left;
            for (int i=1; i<h1; i++ ) {
                rtemp=rtemp.right;
                ltemp=ltemp.left;
                mtemp=mtemp.right;
            }
            if (ltemp==null) {
                break; 
            }
            else if (rtemp!=null) {
                sum+=(1<<h1);
                break;
            } 
            else if (mtemp==null) {
                temp=temp.left;
            }
            else {
                sum+=1<<(h1-1);
                temp=temp.right;
            }
        }
        return sum;
    }
}
