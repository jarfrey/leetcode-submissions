class Solution {
    public int maxArea(int[] height) {
        // since a column can only give water up to its own height we can use that
        // a column will check anything to the right and test how much water it can hold
        // if col1 is bigger, uses col2, otherwise, use col1, then calc area
        // return largest area
        // we'll start from either side, then whichever side is smaller, we will shrink towards that side
        int maxArea = 0;
        int tempArea = 0;

        int right = height.length-1;
        int left = 0;

        while(right>left){
            tempArea = (Math.min(height[right],height[left])*(right-left));
            maxArea = Math.max(tempArea,maxArea);

            if(height[right]>height[left]){
                left++;
            }else{
                right--;
            }
        }

        // for (int i = 0; i < height.length-1; i++){
        //     for (int j = 1; j < height.length; j++){
        //         if(height[i] > height[j]){
        //             tempArea = height[j]*(j-i);
        //         }else{
        //             tempArea = height[i]*(j-i);
        //         }


        //         if (tempArea > maxArea){
        //             maxArea = tempArea;
        //         }
        //     }
        // }
        return maxArea;
    }
}
