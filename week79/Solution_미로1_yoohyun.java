import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] board = new int[16][16];
		int[] start = new int[2];
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		for(int test_case = 1; test_case <= 10; test_case++){
			sb.append("#").append(test_case).append(" ");
			int find = 0;
			br.readLine();
			for(int i = 0; i < 16; i++) {
				String input = br.readLine();
				for(int j = 0; j < 16; j++) {
					board[i][j] = input.charAt(j) - '0';
					if(board[i][j] == 2) {
						start[0] = i;
						start[1] = j;
					}
				}
			}
			Queue<Integer> queue = new LinkedList<>();
			queue.add(start[0]);
			queue.add(start[1]);
			board[start[0]][start[1]] = -1;
			while(!queue.isEmpty()) {
				int y = queue.remove();
				int x = queue.remove();
				
				for(int i = 0; i < 4; i++) {
					int yy = y + dy[i];
					int xx = x + dx[i];
					if(xx >= 0 && xx < 16 && yy >=0 && yy < 16) {
						if(board[yy][xx] == 3) {
							find = 1;
							break;
						}
						else if(board[yy][xx] == 0) {
							queue.add(yy);
							queue.add(xx);
							board[yy][xx] = -1;
						}
							
					}
				}
				if(find == 1) {
					break;
				}
			}
			sb.append(find).append("\n");
		}
		System.out.print(sb);
	}
}
