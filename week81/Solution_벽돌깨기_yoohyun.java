import java.io.*;
import java.util.*;

class Solution{
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
    static int min, N, W, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            
            int[][] board = new int[H][W];
            for(int i = 0; i < H; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < W; j++) {
            		board[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            dropBall(0, board);
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
    public static boolean dropBall(int count, int[][] board) {
    	int result = getRemain(board);
    	if(result == 0) {
			min = 0;
			return true;
		}

    	//종료 조건
    	if(count == N) {
    		min = Math.min(min, result);
			return false;
    	}
    	int[][] newBoard = new int[H][W];
    	for(int j = 0; j < W; j++) {
        	int i = 0;
        	while(i < H && board[i][j] == 0) {
        		i++;
        	}
        	if(i == H) {
        		continue;
        	}else {
        		copyBoard(board, newBoard);
        		
        		bomb(newBoard, i, j);
        		down(newBoard);
        		
        		if(dropBall(count+1,newBoard)) return true;
        	}
        }
    	return false;
    }
    public static void bomb(int[][] board, int i, int j) {
    	Queue<Integer> queue = new LinkedList<>();
    	if(board[i][j] > 1) {
    		queue.add(j);
    		queue.add(i);
    		queue.add(board[i][j]);
    	}
    	board[i][j] = 0;
    	while(!queue.isEmpty()) {
    		int x = queue.remove();
    		int y = queue.remove();
    		int area = queue.remove();
    		for(int k = 0; k < 4; k++) {
    			int xx = x;
    			int yy = y;
    			for(int l = 1; l < area; l++) {
    				xx += dx[k];
        			yy += dy[k];
        			if(xx >= 0 && xx < W && yy >= 0 && yy < H && board[yy][xx] != 0) {
        				if(board[yy][xx] > 1) {
        					queue.add(xx);queue.add(yy); queue.add(board[yy][xx]);
        				}
        				board[yy][xx] = 0;
        			}
    			}
    		}
    	}
    }
    public static void down(int[][] board) {
		for (int j = 0; j < W; j++) {
			int i = H-1;
			while(i>0) {
				if(board[i][j]==0) {
					int nr = i-1;
					while(nr>0 && board[nr][j]==0) --nr;
					board[i][j] = board[nr][j];
					board[nr][j] = 0;
				}
				--i;
			}
		}
	}
    public static int getRemain(int[][] board) {
		int count = 0;
		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				if(board[i][j]>0) count++;
			}
		}
		return count;
	}

    public static void copyBoard(int[][] origin, int[][] newBoard) {
    	for(int i = 0; i < H; i++) {
    		for(int j = 0; j < W; j++) {
    			newBoard[i][j] = origin[i][j];
    		}
    	}
    }
}
