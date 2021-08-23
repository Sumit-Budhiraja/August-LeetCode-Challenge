class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(nums, root);
        int left=0;
        int right=nums.size()-1;
        while(left<right){
            if(nums.get(right)+nums.get(left) == k) return true;
            if(nums.get(right)+nums.get(left) <k) {
                left++;
            }
            else {
                right--;
            }
        }
        return false;
    }
    private void inOrder(List<Integer> nums, TreeNode root){
        if(root== null) return;
        inOrder(nums,root.left);
        nums.add(root.val);
        inOrder(nums,root.right);
    }
}