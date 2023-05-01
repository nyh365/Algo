import java.io.*;
import java.util.*;

public class Main {
	static int R,C,T;
	static int[][] room;
	static int[] fresh;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		fresh = new int[2];
		int cnt = 0;
		room = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j] == -1) {
					fresh[cnt++] = i;
				}
			}
		}
		
		for(int time = 0; time < T; time++) {
			int[][] tmp = copy();
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(room[i][j] >= 5) {
						for(int k = 0; k < 4; k++) {
							int x = j + dx[k];
							int y = i + dy[k];
							if(x < 0 || x >= C || y < 0 || y >= R || tmp[y][x] == -1) continue;
							tmp[y][x] += room[i][j] / 5;
							tmp[i][j] -= room[i][j] / 5;
						}
					}
				}
			}
			room = tmp;
			up();
			down();
		}
		
		System.out.println(result());
	}
	public static int[][] copy() {
		int[][] tmp = new int[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				tmp[i][j] = room[i][j];
			}
		}
		return tmp;
	}
	public static int result() {
		int result = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				result += room[i][j];
			}
		}
		return result + 2;
	}
	public static void up() {
		int y = fresh[0];
		
		int pre = room[y][1];
		room[y][1] = 0;
		for(int j = 2; j < C; j++) {
			int tmp = room[y][j];
			room[y][j] = pre;
			pre = tmp;
		}
		
		for(int i = y - 1; i >= 0 ; i--) {
			int tmp = room[i][C - 1];
			room[i][C - 1] = pre;
			pre = tmp;
		}
		
		for(int j = C - 2; j >= 0; j--) {
			int tmp = room[0][j];
			room[0][j] = pre;
			pre = tmp;
		}
		
		for(int i = 1; i < y ; i++) {
			int tmp = room[i][0];
			room[i][0] = pre;
			pre = tmp;
		}
	}
	public static void down() {
		int y = fresh[1];
		
		int pre = room[y][1];
		room[y][1] = 0;
		for(int j = 2; j < C; j++) {
			int tmp = room[y][j];
			room[y][j] = pre;
			pre = tmp;
		}
		
		for(int i = y + 1; i < R ; i++) {
			int tmp = room[i][C-1];
			room[i][C-1] = pre;
			pre = tmp;
		}
		
		for(int j = C - 2; j >= 0; j--) {
			int tmp = room[R-1][j];
			room[R-1][j] = pre;
			pre = tmp;
		}
		
		for(int i = R - 2; i >= y + 1 ; i--) {
			int tmp = room[i][0];
			room[i][0] = pre;
			pre = tmp;
		}
	}
}
