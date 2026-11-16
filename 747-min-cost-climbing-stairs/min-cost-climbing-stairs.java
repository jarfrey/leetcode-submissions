class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] currentPrice = new int[n+1]; // min cost to get to index cost.length, so need length cost.length+1
        for (int i = 2; i <= n; i++){
            int potentialStep1 = currentPrice[i-1]+cost[i-1];
            int potentialStep2 = currentPrice[i-2]+cost[i-2];
            currentPrice[i] = Math.min(potentialStep1, potentialStep2);
        }
        return currentPrice[n];
    }
}

// every time we want to step we should look at the 2 possibilities
// we can either go from 0 or 1 -> this is weird so we should do it from the middle
// so well grab whichever step length will be the smallest and have that be the current price to get to step i
// well keep grabbing whichever way that gets us to the