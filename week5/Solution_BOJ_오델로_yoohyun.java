import java.io.*;
import java.util.*;

public class Main {
	static char[][] board = new char[7][7];
	static int[] dx = {-1,-1,0,1,1,1,0,-1};
	static int[] dy = {0,1,1,1,0,-1,-1,-1};
	static int black = 2;
	static int white = 2;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 7; i++) {
			Arrays.fill(board[i], '.');
		}
		board[3][3] = 'W'; board[4][4] = 'W';
		board[3][4] = 'B'; board[4][3] = 'B';
		
		char turn = 'B';
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = turn;
			game(c,r, turn);
			if(turn == 'B') turn = 'W';
			else turn = 'B';
		}
		Print();
		System.out.println(white > black ? "White" : "Black");
	}
	public static void game(int x, int y, char turn) {		
		for(int k = 0; k < 8; k++) {
			boolean flag = false;
			int change = 0;
			int xx = x;
			int yy = y;
			while(true) {
				xx += dx[k]; yy += dy[k];
				if(xx < 1 || xx >= 7 || yy < 1 || yy >= 7) break;
				if(board[yy][xx] == '.') break;
				if(board[yy][xx] == turn) {
					flag = true; break;
				}
			}
			if(flag) {
				xx = x; yy = y;
				while(true) {
					xx += dx[k]; yy += dy[k];
					if(board[yy][xx] == turn) {
						break;
					}
					change += 1;
					board[yy][xx] = turn;
				}
				if (turn == 'B') {
					white -= change;
					black += change;
				}
				else {
					black -= change;
					white += change;
				}
			}
		}
	}
	public static void Print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < 7; i++) {
			for(int j = 1; j < 7; j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
