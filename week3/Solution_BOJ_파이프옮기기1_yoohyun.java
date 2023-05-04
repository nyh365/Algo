import java.io.*;
import java.util.*;
public class Main {
	static int[][] dx = {{-1},{0},{-1,0,-1}};
	static int[][] dy = {{0},{-1},{0,-1,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] house = new int[N+2][N+2];
		int[][][] result = new int[N+2][N+2][3];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result[1][2][0] = 1;
		for(int i = 1; i <= N + 1; i++) {
			for(int j = 1; j <= N + 1; j++) {
				if(house[i][j] == 0) {
					for(int k = 0; k < 3; k++) {
						// 파이프가 가로일 때
						if(k == 0) {
							for(int l = 0; l < 3; l++) {
								if(l == 1) continue;
								boolean flag = false;
								for(int m = 0; m < dx[l].length; m++) {
									int x = j - 1 + dx[l][m];
									int y = i + dy[l][m];
									if(x < 1 || x > N || y < 1 || y > N) {
										flag = true;
										break;
									}
									if(house[y][x] == 1) {
										flag = true;
										break;
									}
								}
								if(!flag)
									result[i][j][k] += result[i][j - 1][l];
							}
						}  else if(k == 1) {// 파이프가 세로일 때
							for(int l = 0; l < 3; l++) {
								boolean flag = false;
								if(l == 0) continue;
								for(int m = 0; m < dx[l].length; m++) {
									int x = j + dx[l][m];
									int y = i - 1 + dy[l][m];
									if(x < 1 || x > N || y < 1 || y > N){
										flag = true;
										break;
									}
									if(house[y][x] == 1) {
										flag = true;
										break;
									}
								}
								if(!flag)
									result[i][j][k] += result[i-1][j][l];
							}
						}
						else { // 파이프가 대각선일 때
							for(int l = 0; l < 3; l++) {
								boolean flag = false;
								for(int m = 0; m < dx[l].length; m++) {
									int x = j - 1 + dx[l][m];
									int y = i - 1 + dy[l][m];
									if(x < 1 || x > N || y < 1 || y > N){
										flag = true;
										break;
									}
									if(house[y][x] == 1) {
										flag = true;
										break;
									}
								}
								if(!flag)
									result[i][j][k] += result[i - 1][j - 1][l];
							}
						}
					}
				}
			}
		}

		System.out.println(result[N+1][N+1][0] + result[N+1][N+1][1] + result[N+1][N+1][2]);
	}
}
