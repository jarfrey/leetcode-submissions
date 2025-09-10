class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxStreak = 0;
        int currentStreak = 0;
        for (int i = 0; i<s.length();i++){
            for (int j = i; j<s.length(); j++){
                if (!(s.substring(i,j).contains(s.substring(j,j+1)))){
                    
                    currentStreak++;
                    //return 1;
                }else{
                    j=s.length()+1;
                }
            }
            if(currentStreak > maxStreak){
                maxStreak = currentStreak;
            }
            currentStreak=0;
        }
        return maxStreak;
    }
}
