class Solution 
{
    int count = 0;
    public int goodNodes(TreeNode root) 
    {
        util(root , Integer.MIN_VALUE);
        return count;
    }
    void util(TreeNode root , int max)
    {
        if(root==null)
            return;
        
        if(root.val>=max)
            count++;
        
        util(root.left , Math.max(max , root.val));
        util(root.right , Math.max(max , root.val));
    }
}