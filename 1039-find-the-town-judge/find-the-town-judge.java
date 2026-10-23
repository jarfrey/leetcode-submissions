// since there are people 1 to n
// we will start by saying 1 is the judge
// if 1 trusts 
// we could just make like 2 arrays and call it a day

class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] trusted = new int[n+1];
        boolean[] truster = new boolean[n+1];
        ArrayList<Integer> candidates = new ArrayList<Integer>();

        if(n == 1){
            return 1;
        }

        for (int i = 0; i < trust.length;i++){
            trusted[trust[i][1]] += 1;
            if(trusted[trust[i][1]] == n-1){
                candidates.add(trust[i][1]);
            }
            truster[trust[i][0]] = true;
        }
        
        for (int j = 0; j < candidates.size(); j++){
            if (truster[candidates.get(j)] == false){
                return candidates.get(j);
            }
        }
        return -1;
    }
}

