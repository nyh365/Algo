import java.io.*;
import java.util.*;

public class Main {
	static char[][] board;
	static int result = Integer.MIN_VALUE;
	static int N;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		char tmp;
		int value;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(j + 1 < N) {
					tmp = board[i][j]; board[i][j] = board[i][j+1]; board[i][j+1] = tmp;
					value = check();
					result = Math.max(value, result);
					tmp = board[i][j]; board[i][j] = board[i][j+1]; board[i][j+1] = tmp;
				}
				if(i + 1 < N) {
					tmp = board[i][j]; board[i][j] = board[i+1][j]; board[i+1][j] = tmp;
					value = check();
					result = Math.max(value, result);
					tmp = board[i][j]; board[i][j] = board[i+1][j]; board[i+1][j] = tmp; 
				}
			}
		}
		System.out.println(result);
	}
	public static int check() {
		int value = 1;
		int cnt = 1;
		for(int i = 0; i < N; i++) {
			cnt = 1;
			//가로
			for(int j = 0; j < N - 1; j++) {
				if(board[i][j] == board[i][j+1])
					cnt++;
				else 
					cnt = 1;
				value = Math.max(cnt, value);
			}
			
			//세로
			cnt = 1;
			for(int j = 0; j < N - 1; j++) {
				if(board[j][i] == board[j+1][i])
					cnt++;
				else 
					cnt = 1;
				value = Math.max(cnt, value);
			}
			
		}
		return value;
	}
}  
