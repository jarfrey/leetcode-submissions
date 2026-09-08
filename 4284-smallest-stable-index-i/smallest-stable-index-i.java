class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // save the smallest stable index every time one is found smaller
        // when iterating from left -> right, check if i is the new maximum?
        int prevGreatest = nums[0];
        int prevMinimum = nums[0]; 

        for (int j = 0; j < nums.length; j++){
            if (nums[j] < prevMinimum){
                prevMinimum = nums[j];
            }
        }
        
        if (prevGreatest - prevMinimum <= k){
                return 0;
        }

        for (int i = 1; i < nums.length; i++){
            if (nums[i] > prevGreatest)
                prevGreatest = nums[i];
            if (nums[i-1] <= prevMinimum){
                prevMinimum = nums[i];
                for (int j = i+1; j < nums.length; j++){
                    if (nums[j] < prevMinimum){
                        prevMinimum = nums[j];
                    }
                }
            }
            if (prevGreatest - prevMinimum <= k){
                return i;
            }
        }
        return -1;
    }
}