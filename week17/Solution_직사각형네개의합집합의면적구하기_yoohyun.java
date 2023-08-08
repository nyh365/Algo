import java.io.*;
import java.util.*;

public class Main {
	static int[][] board;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = 0;
		boolean board[][] = new boolean[101][101];
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int x = x1; x < x2; x++) {
				for(int y = y1; y < y2; y++) {
					board[x][y] = true;
				}
			}
		}
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++)
				if(board[i][j])
					count++;
		}
		System.out.print(count);
	}
}
