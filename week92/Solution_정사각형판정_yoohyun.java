import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			String result = "yes";
			boolean flag = false;
			boolean flag_end = false;
			int board[][] = new int[N][N];
			int start = -1;
			int end = 0;
			int col = 0;
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				for(int j = 0; j < N; j++) {
					board[i][j] = input.charAt(j);
				}
			}
			
			for(int i = 0; i < N; i++) {
				if(!flag) {
					for(int j = 0; j < N; j++) {
						if(flag && board[i][j] == '#') {
							if(board[i][j] == '#')
								end = j;
							else {
								result = "no";
								flag_end = true;
							}
						}
						if(start == -1 && board[i][j] == '#') {
							start = j;
							col = i;
							end = start;
							flag = true;
						}
					}
				}
				else {
					for(int j = 0; j < N; j++) {
						if(i - col + 1 > end-start + 1) {
							if(board[i][j] == '#') {
								result = "no";
								flag_end = true;
							}
						}
						else {
							if(board[i][j] == '#') {
								if(start > j && j > end) {
									result = "no";
									flag_end = true;
								} 
							}
							else {
								if(start <= j && j <= end) {
									result = "no";
									flag_end = true;
								} 
							}
						}
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
