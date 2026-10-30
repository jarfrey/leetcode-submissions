class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingColor = image[sr][sc];
        recurFlood(image, sr, sc, startingColor, color);
        return image;
        // check top
        // check right
        // check bottom
        // check left
        // if they are successful, jump there and recur
    }
    private void recurFlood(int[][] image, int sr, int sc, int startingColor, int floodColor){
        if (image[sr][sc] == floodColor){
            return;
        }
        if (image[sr][sc] == startingColor){
            image[sr][sc] = floodColor;

            if (image.length > sr+1){
                recurFlood(image, sr+1, sc, startingColor, floodColor);
            }
            if (image[0].length > sc+1){
                recurFlood(image, sr, sc+1, startingColor, floodColor);
            }
            if (sr > 0){
                recurFlood(image, sr-1, sc, startingColor, floodColor);
            }
            if (sc > 0){
                recurFlood(image, sr, sc-1, startingColor, floodColor);
            }
        }
        
        
    } 

}