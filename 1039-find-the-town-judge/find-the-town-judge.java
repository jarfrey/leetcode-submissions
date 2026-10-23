
// we could just make like 2 arrays and call it a day
// just save who is trusted and who is truster
// then do stuff based off of that 

class Solution {
    public int findJudge(int n, int[][] trust) {

        if(n == 1){
            return 1;
        }

        int[] trusted = new int[n+1];
        boolean[] truster = new boolean[n+1];


        for (int i = 0; i < trust.length;i++){
            trusted[trust[i][1]] += 1;
            truster[trust[i][0]] = true;
        }

        for (int j = 1; j <= n; j++){
            if(trusted[j] == n-1 && truster[j] == false){
                return j;
            }
        }
        return -1;
    }
}

