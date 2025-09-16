class Solution {
    public boolean squareIsWhite(String coordinates) {
        String first = "aceg";
        String second = "bdfh";
        String numFirst = "1357";
        String numSecond = "2468";
        if(first.contains(coordinates.substring(0,1))){
            if(numFirst.contains(coordinates.substring(1,2))){
                return false;
            }else{
                return true;
            }
        }else{
            if(numSecond.contains(coordinates.substring(1,2))){
                return false;
            }else{
                return true;
            }
        }
    }
}
