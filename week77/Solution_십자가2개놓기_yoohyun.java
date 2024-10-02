import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int result = Integer.MIN_VALUE;
	static int N, M;
	static char[][] board;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for(int i = 0; i < N; i++) {
        	board[i] = br.readLine().toCharArray();
        }
        
        findCrossWidth();
        
        System.out.print(result);
    }
	private static void findCrossWidth() {
		int xx ,yy, l;
		boolean flag;
		for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		if(board[i][j] == '.') continue;
        		
        		flag = true;
        		
        		for(int length = 0; flag ;length++) {
        			for(int k = 0; k < 4; k++) {
            			xx = j + length * dx[k];
            			yy = i + length * dy[k];
            				
        				if(xx < 0 || xx >= M || yy < 0 || yy >= N || board[yy][xx] == '.') {
        					flag = false; 
        					break;
        				}
            		}
        			
        			if(flag) {
        				checkCross(j, i, length, '.');
        				l = findCross();
        				if(l != -1) {
        				result = Math.max(result, (4 * length + 1) * (4 * l + 1));
        				}
        				checkCross(j, i, length, '#');
        			}
    			}
        	}
        }
	}
	
	private static int findCross() {
		boolean flag;
		int length = -1;
		for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		if(board[i][j] == '.') continue;
        		
        		flag = true;
        		
        		int xx, yy;
        		for(int l = 1; flag; l++) {
        			for(int k = 0; k < 4; k++) {
            			xx = j + l * dx[k];
            			yy = i + l * dy[k];
            				
        				if(xx < 0 || xx >= M || yy < 0 || yy >= N || board[yy][xx] == '.') {
        					flag = false; 
        					length = Math.max(length, l - 1);
        					break;
        				}
            		}
    			}
        	}
        }
		return length;
	}
	
	private static void checkCross(int j, int i, int length, char order) {
		for(int k = 0; k < 4; k++) {
			for(int l = 0; l <= length; l++) {
				board[i + l * dy[k]][j + l * dx[k]] = order;
			}
		}
	}
}
