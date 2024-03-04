import java.io.*;
import java.util.*;

public class Main {
	static int[][] square;
	static int N, M;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 높이
		M = Integer.parseInt(st.nextToken()); // 넓이
		int R = Integer.parseInt(st.nextToken());
		
		square = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j = 0; j < M; j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < R; i++) {
			rotation();
		}
		Print();
	}
	
	public static void rotation() {
		boolean[][] check = new boolean[N][M];
		for(int i = 0, j = 0; ; i++, j++) {
			if(i >= 0 && i < N && j >=0 && j < M && !check[i][j]) {
				int xx = j, yy = i;
				int tmp = square[yy][xx];
				for(int k = 0; k < 4; k++) {
					boolean flag = true;
					while(flag) {
						xx += dx[k]; yy += dy[k];
						if(yy >= i && yy < N - i && xx >= j && xx < M - j) {
							int t = square[yy][xx];
							square[yy][xx] = tmp;
							tmp = t;
							check[yy][xx] = true;
						}
						else {
							xx -= dx[k]; yy -=dy[k];
							break;
						}
					}
				}
			}
			else break;
		}
	}
	public static void Print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(square[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
