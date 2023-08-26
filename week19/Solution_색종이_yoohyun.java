import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] board = new boolean[101][101];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = Integer.parseInt(br.readLine());		
		int size = 0;
		
		for(int i = 1; i <= count; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int lx = x; lx < x + 10; lx++) {
				for(int ly = y; ly < y + 10; ly++)
					board[lx][ly] = true;
			}
			
		}
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				if(board[i][j])
					size++;
			}
		}
		System.out.print(size);
				
	}
}
