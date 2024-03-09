import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int[][] board;
	public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      board = new int[N][N];
      
      for(int i = 0; i < N; i++) {
    	  String input = br.readLine();
    	  for(int j = 0; j < N; j++) {
    		  board[i][j] = input.charAt(j) - '0';
    	  }
      }
      System.out.println(dfs(0,0,N));
    }
    public static String dfs(int x1, int y1, int size) {
    	if(size == 1) {
    		return board[y1][x1] + "";
    	}
    	String a = dfs(x1, y1, size / 2);
    	String b = dfs(x1 + size / 2, y1, size / 2);
    	String c = dfs(x1, y1 + size / 2, size / 2);
    	String d = dfs(x1 + size / 2, y1 + size /2, size / 2);
    
    	if(a.equals("1") || a.equals("0")) {
    		if(a.equals(b) && b.equals(c) && c.equals(d)) {
        		return a;
        	}
    	}
    	return "(" + a + b + c + d + ")";
    }
}
