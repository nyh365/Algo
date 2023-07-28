import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] dx = {1,1,1};
    static int[] dy = {-1,0,1};
    static char[][] street;
    static int R, C;
	static int result = 0;
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st = new StringTokenizer(br.readLine());
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      street = new char[R][C];
      
      for(int i = 0; i < R; i++) {
    	  char[] input = br.readLine().toCharArray();
    	  for(int j = 0; j < C; j++) {
    		  street[i][j] = input[j];
    	  }
      }
      
      for(int i = 0; i < R; i++) {
    	  if(dfs(i, 0)) result++;
      }
      
      System.out.println(result);
    }
    public static boolean dfs(int row, int col) {
    	if(col == C - 1) {
    		return true;
    	}
    	for(int i = 0; i < 3; i++) {
    		int x = col + dx[i];
    		int y = row + dy[i];
    		if(y >= 0 && y < R) {
    			if(street[y][x] == '.') {
    				street[y][x] = 'x';
    				if(dfs(y,x)) {
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
}
