import java.io.*;
import java.util.*;

public class Main {
	static int[][] board = new int[5][5];
	static int[] arr = new int[25];
	static int count = 0;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		boolean flag = false;
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}			
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				circle(Integer.parseInt(st.nextToken()));
				result++;
				count = 0;
				v_bingo(); h_bingo(); c_bingo1(); c_bingo2();
				if(count >= 3) {
					flag = true;
					break;
				}
					
			}
			if(flag)
				break;
		}		
		System.out.println(result);
		
	}
	public static void circle(int num) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(board[i][j] == num)
					board[i][j] = -1;
			}
		}
		
	}
	public static void v_bingo() {
		for(int i = 0; i < 5; i++) {
			int cnt = 0;
			for(int j = 0; j < 5; j++) {
				if(board[j][i] == -1)
					cnt++;
				if(cnt == 5)
					count++;
			}
		}
	}
	public static void h_bingo() {
		for(int i = 0; i < 5; i++) {
			int cnt = 0;
			for(int j = 0; j < 5; j++) {
				if(board[i][j] == -1)
					cnt++;
				if(cnt == 5)
					count++;
			}
		}
	}
	public static void c_bingo1() {
		for(int i = 0; i < 5; i++) {
			if(board[i][i] != -1)
				return;
		}
		count++;
	}
	public static void c_bingo2() {
		for(int i = 0; i <= 4; i++) {
			if(board[4-i][i] != -1)
				return;
		}
		count++;
	}
}
