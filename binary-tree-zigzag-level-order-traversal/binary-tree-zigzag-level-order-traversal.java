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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean isLeftToRight=true;
        while(!queue.isEmpty())
        {
            List<Integer> currLevel=new ArrayList<Integer>();
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++)
            {
            TreeNode curr=queue.poll();
            if(isLeftToRight==true)
            currLevel.add(curr.val);
            else
            currLevel.add(0,curr.val);
            if(curr.left!=null)
            queue.add(curr.left);
            if(curr.right!=null)
            queue.add(curr.right);
            }
            result.add(currLevel);
            
            isLeftToRight=!isLeftToRight;
            
        }
        return result;
        
        
    }
}