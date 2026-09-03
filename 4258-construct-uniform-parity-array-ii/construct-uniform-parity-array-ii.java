class Solution {
    public boolean uniformArray(int[] nums1) {
        int lowestOdd = Integer.MAX_VALUE; // this is so the first odd number sets it
        int lowestEven = Integer.MAX_VALUE; // same
        boolean noOddNum = true; // for edgecase of max value odd number not being checked
        boolean noEvenNum = true;
        if (nums1.length == 1){ // if it's 1 its good
            return true;
        }
        for (int i = 0; i < nums1.length; i++){ // iterate thru
            if (nums1[i] % 2 == 0){ // if even
                if (nums1[i] < lowestEven){ // if greater tahn current lowest
                    lowestEven = nums1[i]; // set new
                    noEvenNum = false;
                }

            } else { // if odd
                if (nums1[i] < lowestOdd){ // if less than current lowest
                    lowestOdd = nums1[i]; // set new
                    noOddNum = false; // set flag
                }

            }
        }

        if (noOddNum || noEvenNum){ // if no odd, must be even
            return true;
        }
        if (lowestEven - lowestOdd >= 1){ // if this is true, then all other even odd numbers must work in making things odd
            return true;
        }

        return false; // otherwise doesn't work
    }
}

// keep track of lowest odd number, if no such number exists then all even and we're good
// keep track of greatest even number
// if greatest even number - lowest odd number !>= 1, then ERROR!!! BOOO!!!