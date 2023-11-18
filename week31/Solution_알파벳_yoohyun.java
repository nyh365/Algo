import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static boolean[] alp = new boolean[26];
    static char[][] board;
    static int R, C;
	static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st = new StringTokenizer(br.readLine());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      board = new char[R][C];
      
      for(int i = 0; i < R; i++) {
    	  char[] input = br.readLine().toCharArray();
    	  for(int j = 0; j < C; j++) {
    		  board[i][j] = input[j];
    	  }
      }
      dfs(0,0,1);
      
      System.out.println(result);
    }
    public static void dfs(int row, int col, int count) {
    	alp[board[row][col] - 'A'] = true;
    	for(int i = 0; i < 4; i++) {
    		int x = col + dx[i];
    		int y = row + dy[i];
    		if(x >= 0 && x < C && y >= 0 && y < R) {
    			if(!alp[board[y][x] - 'A']) {
    				dfs(y,x, count + 1);
    			}
    		}
    	}
    	alp[board[row][col] - 'A'] = false;
    	result = Math.max(result, count);
    	return;
    }
}
