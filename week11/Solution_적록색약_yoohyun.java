import java.io.*;
import java.util.*;

public class Main {
	static char[][] color;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
    static int area1 = 0;
    static int area2 = 0;
    static int N;
	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new char[N][N];

        for(int i = 0; i < N; i++) {
        	char[] input = br.readLine().toCharArray();
        	for(int j = 0; j < N; j++) {
        		color[i][j] = input[j];
        	}
        }
        area1 = bfs();
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(color[i][j] == 'G')
        			color[i][j] = 'R';
        	}
        }
        area2 = bfs();
        
        System.out.println(area1 + " " + area2);
	}   
	public static int bfs() {
		int result = 0;
		boolean check[][] = new boolean[N][N];
        Queue<Integer> queue = new LinkedList<>();
        for(int r = 0; r < N; r++) {
        	for(int c = 0; c < N; c++) {
        		if(!check[r][c]) {
        			check[r][c] = true;
        			queue.add(c);
        			queue.add(r);
        			while(!queue.isEmpty()) {
        	        	int size = queue.size() / 2;
        	        	for(int i = 0; i < size; i++) {
        	        		int x = queue.remove();
        	        		int y = queue.remove();
        	        		for(int k = 0; k < 4; k++) {
        	            		int xx = x + dx[k];
        	            		int yy = y + dy[k];
        	            		if(xx >= 0 && xx < N && yy >= 0 && yy < N) {
        	            			if(!check[yy][xx]) {
        	            				if(color[yy][xx] == color[r][c]) {
            	            				queue.add(xx);
            	            				queue.add(yy);
            	            				check[yy][xx] = true;
            	            			}
        	            			}
        	            		}
        	            	}
        	        	}
        	        }
        			result++;
        		}
        	}
        }
        return result;
	}
}
