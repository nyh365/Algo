import java.io.*;
import java.util.*;

public class Main {
	static int[][] square;
	static int N, M;
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
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			switch(Integer.parseInt(st.nextToken())) {
			case 1 : rotation1(); break;
			case 2 : rotation2(); break;
			case 3 : rotation3(); break;
			case 4 : rotation4(); break;
			case 5 : rotation5(); break;
			case 6 : rotation6(); break;
			}
		}
		
		Print();
	}
	
	public static void rotation1() {
		int[][] tmp = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmp[N - 1 - i][j] = square[i][j];
			}
		}
		square = tmp;
	}
	public static void rotation2() {
		int[][] tmp = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmp[i][M - 1 - j] = square[i][j];
			}
		}
		square = tmp;
	}
	public static void rotation3() {
		int[][] tmp = new int[M][N];
		
		for(int j = 0; j < M; j++) {
			int k = 0;
			for(int i = N - 1; i >= 0; i--) {
				tmp[j][k++] = square[i][j];
			}
		}
		
		square = tmp;
		int l_tmp = M;
		M = N;
		N = l_tmp;
		
	}
	public static void rotation4() {
		int[][] tmp = new int[M][N];
		
		for(int i = 0; i < N; i++) {
			int k = 0;
			for(int j = M - 1; j >=0; j--) {
				tmp[k++][i] = square[i][j];
			}
		}
		
		square = tmp;
		int l_tmp = M;
		M = N;
		N = l_tmp;
	}
	public static void rotation5() {
		int[][] tmp = new int[N][M];
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M /2; j++) {
				tmp[i][j] = square[i + (N / 2)][j];
			}
		}
		for(int i = 0; i < N / 2; i++) {
			for(int j = M / 2; j < M; j++) {
				tmp[i][j] = square[i][j - (M / 2)];
			}
		}
		
		for(int i = N / 2; i < N; i++) {
			for(int j = 0; j < M / 2; j++) {
				tmp[i][j] = square[i][j + (M / 2)];
			}
		}
		
		for(int i = N / 2; i < N; i++) {
			for(int j = M / 2 ; j < M; j++) {
				tmp[i][j] = square[i - (N / 2)][j];
			}
		}
		square = tmp;
		
	}
	public static void rotation6() {
		int[][] tmp = new int[N][M];
		for(int i = 0; i < N / 2; i++) {
			for(int j = 0; j < M /2; j++) {
				tmp[i][j] = square[i][j + (M / 2)];
			}
		}
		for(int i = 0; i < N / 2; i++) {
			for(int j = M / 2; j < M; j++) {
				tmp[i][j] = square[i + (N / 2)][j];
			}
		}
		
		for(int i = N / 2; i < N; i++) {
			for(int j = 0; j < M / 2; j++) {
				tmp[i][j] = square[i - (N / 2)][j];
			}
		}
		
		for(int i = N / 2; i < N; i++) {
			for(int j = M / 2 ; j < M; j++) {
				tmp[i][j] = square[i][j - (M / 2)];
			}
		}
		square = tmp;
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
