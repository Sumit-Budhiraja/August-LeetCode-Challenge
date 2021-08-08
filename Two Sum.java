class Solution {
    public int[] twoSum(int[] nums, int target) {
        // o(n^2)
        // int arr[] = new int[2];
        // boolean flag = false;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j]==target){
        //             arr[0] = i;
        //             arr[1] = j;
        //             flag = true;
        //             break;
        //         }
        //     }
        //     if(flag)
        //         break;
        // }
        // return arr;
        
        // using map for reducing the time
        
        Map<Integer, Integer> map = new HashMap<>();
        
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
            
            map.put(nums[i], i);
        }
        return null;
    }
}