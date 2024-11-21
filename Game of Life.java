/**
 * The board is made up of an m x n grid of cells.
 * Each cell has an initial state: live (represented by a 1) or dead (represented by a 0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
    -Any live cell with fewer than two live neighbors dies as if caused by under-population.
    -Any live cell with two or three live neighbors lives on to the next generation.
    -Any live cell with more than three live neighbors dies, as if by over-population.
    -Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

* The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board.
* In this process, births and deaths occur simultaneously.
* Given the current state of the board, update the board to reflect its next state.
 */

class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] dir = {{-1,-1}, {-1,0}, {-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int live = 0;
                for(int[] d:dir){
                    int r = i+d[0];
                    int c = j+d[1];

                    if(r>=0 && r<rows && c>=0 && c<cols && Math.abs(board[r][c])==1){
                        live++;
                    }
                }
                if(board[i][j]==1 && (live<2 || live>3)){
                    board[i][j]=-1;
                }else if(board[i][j]==0 && live==3){
                    board[i][j]=2;
                }
            }
            
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]==-1){
                    board[i][j]=0;
                }
                else if(board[i][j]==2){
                    board[i][j]=1;
                }
            }
        }
    }
}