class Solution {
    public int maxProduct(int[] nums) {
        // iterate through and find the greatest 2 items in array
        // we can do this by saving the greatest then second greatest
        // great1 is less greatest, great2 is greatest greatest
        // if x > great1 > great2, great2 = x
        // if x > great1 < great1, great1 = x
        // if x < great1, nothing
        // we dont even need indexes...
        // once this is done then just do (nums[great1]-1)*(nums[great2]-1)
        // then return this
        // int greater = Math.min(nums[0],nums[1]);
        // int greatest = Math.max(nums[1],nums[0]);
        int greater = 0;
        int greatest = 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > greater){
                if (nums[i] > greatest) {
                    greater = greatest;
                    greatest = nums[i];
                } else {
                    greater = nums[i];
                }
            }
        }
        // System.out.println(greater);
        // System.out.println(greatest);
        return (greatest-1) * (greater-1);
    }
}