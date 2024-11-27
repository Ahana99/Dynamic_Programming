public class Solution
{
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        int targetColor = image[x][y];
        
        if(targetColor == newColor) return image;
        
        fillColor(image, x, y, targetColor, newColor);
        return image;
    }
    public static void fillColor(int[][] image, int x, int y, int targetColor, int newColor){
        if(x<0 || x>=image.length || y<0 || y>=image[0].length || image[x][y]!=targetColor){
            return;
        }

        image[x][y] = newColor;

        fillColor(image, x-1, y, targetColor, newColor);
        fillColor(image, x+1, y, targetColor, newColor);
        fillColor(image, x, y-1, targetColor, newColor);
        fillColor(image, x, y+1, targetColor, newColor);
    }
}