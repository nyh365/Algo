import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,-1,1,-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {-1,1,0,0,-1,-2,-2,-1,1,2,2,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] board = new int[H][W];
        int[][][] result = new int[H][W][K + 1];
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
            	Arrays.fill(result[i][j], -1);
            }
        }
        
        
        Queue<Integer> queue = new LinkedList<>();
        result[0][0][K] = 0;
        queue.add(0); queue.add(0); queue.add(K);
        
        while(!queue.isEmpty()) {
        	int x = queue.remove();
        	int y = queue.remove();
        	int count = queue.remove();
        	if(x == W - 1 && y == H - 1) break;
        	for(int i = 0; i < 4; i++) {
        		int xx = x + dx[i];
        		int yy = y + dy[i];
        		
        		if(xx < 0 || xx >= W || yy < 0 || yy >= H) continue;
        		if(board[yy][xx] == 1) continue;
        		if(result[yy][xx][count] != -1) continue;
        		result[yy][xx][count] = result[y][x][count] + 1;
        		queue.add(xx); queue.add(yy); queue.add(count);
        	}
        	if(count >= 1) {
        		for(int i = 4; i < 12; i++) {
            		int xx = x + dx[i];
            		int yy = y + dy[i];
            		
            		if(xx < 0 || xx >= W || yy < 0 || yy >= H) continue;
            		if(board[yy][xx] == 1) continue;
            		if(result[yy][xx][count - 1] != -1) continue;
            		result[yy][xx][count - 1] = result[y][x][count] + 1;
            		queue.add(xx); queue.add(yy); queue.add(count - 1);
            	}
        	}
        }
        int min = -1;
        for(int i = 0; i <= K; i++) {
        	if(result[H-1][W-1][i] >= 0) {
        		min = result[H-1][W-1][i];
        		break;
        	}
        }
        System.out.println(min);
    }
}
