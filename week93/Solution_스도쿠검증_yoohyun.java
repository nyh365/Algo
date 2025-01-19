import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[][] board = new int[9][9];
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#").append(test_case).append(" ");
			int result = 0;
			for(int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 9; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if(checkR(board) && checkC(board) && checkB(board))
				result = 1;
			
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
	public static boolean checkR(int[][] board) {
		for(int i = 0; i < 9; i++) {
			boolean[] check = new boolean[10];
			for(int j = 0; j < 9; j++) {
				if(check[board[i][j]]) {
					return false;
				}
				else {
					check[board[i][j]] = true;
				}
			}
		}
		return true;
	}
	public static boolean checkC(int[][] board) {
		for(int i = 0; i < 9; i++) {
			boolean[] check = new boolean[10];
			for(int j = 0; j < 9; j++) {
				if(check[board[j][i]]) {
					return false;
				}
				else {
					check[board[j][i]] = true;
				}
			}
		}
		return true;
	}
	public static boolean checkB(int[][] board) {
		for(int i = 0; i < 9; i += 3) {
			int[] y = {0, 3, 6};
			for(int j = 0; j < 3; j++) {
				boolean[] check = new boolean[10];
				for(int k = 0; k < 3; k++) {
					if(check[board[i + k][y[j] + k]]) {
						return false;
					}
					else {
						check[board[i + k][y[j] + k]] = true;
					}
				}
			}
		}
		return true;
	}
}
