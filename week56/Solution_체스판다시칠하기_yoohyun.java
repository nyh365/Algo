import java.io.*;
import java.util.*;

public class Main {
	public static boolean[][] arr;
	public static int min = 64;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());			
		int M = Integer.parseInt(st.nextToken());

		arr = new boolean[N][M];
		
		for(int i = 0; i < N; i++){
			String str = br.readLine();
			for(int j = 0; j < M; j++){
				if(str.charAt(j) == 'W')
					arr[i][j] = true;
				else
					arr[i][j] = false;
			}
		}

		int Nrow = N - 7;
		int Mrow = M - 7;

		for(int i = 0; i < Nrow; i++){
			for(int j  = 0 ; j < Mrow; j++){
				find(i, j);
			}
		}
		System.out.println(min);
	}

	public static void find(int x, int y){
		int end_x = x + 8;
		int end_y = y + 8;
		int count = 0;

		boolean color= arr[x][y];

		for(int i = x; i < end_x ; i++){
			for(int j = y; j < end_y; j++){
				if(color != arr[i][j])
					++count;
				color = !(color);	
			}
			color = !(color);
		}
		count = Math.min(count, 64 - count);
		
		min = Math.min(count, min);
	}
}
