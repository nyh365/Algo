import java.util.*;
class Solution {
    static int board[][];
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        board = new int[rows + 1][columns + 1];
        int cnt = 1;
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                board[i][j] = cnt++;
            }
        }
        for(int i = 0; i < queries.length; i++){
            answer[i] = change(queries[i]);
        }
        
        return answer;
    }
    public int change(int[] location){
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int x = location[0];
        int y = location[1];
        int	tmp1 = board[x + 1][y];
        int tmp2 = 0;
        int min  = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            while(x >= location[0] && x <= location[2] && y >= location[1] && y <= location[3]) {
                min = Math.min(min, board[x][y]);
                tmp2 = board[x][y];
                board[x][y] = tmp1;
                tmp1 = tmp2;
                x += dx[i];
                y += dy[i];
            }
            if(i != 3) {
	            x += dx[i + 1] - dx[i];
	            y += dy[i + 1] - dy[i];
            }
        }
        return min;
    }
}
