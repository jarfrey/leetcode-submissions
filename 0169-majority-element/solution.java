class Solution {
    public int majorityElement(int[] nums) {
        ArrayList<Integer> arr=  new ArrayList();
        boolean alreadyHas = true;
        int tempCount = 0;
        int maxCount = 0;
        int ret = 0;
        for(int i = 0; i<nums.length;i++){
            for(int j = i; j<nums.length;j++){
                if(nums[j] == nums[i]){
                    tempCount++;
                }

            }
            if(tempCount > maxCount){
                    maxCount = tempCount;
                    ret = nums[i];
            }
            tempCount = 0;
 
        }
        return ret;
    //                    for (int k = 0; k<arr.size();k++){
      //              if (arr.get(k) == nums[k]){
//                        alreadHas = true;
  //                  }
    }
}
