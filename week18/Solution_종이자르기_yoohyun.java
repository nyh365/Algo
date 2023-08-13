import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		boolean[] vertical = new boolean[h + 1];
		boolean[] horizon = new boolean[w + 1];
		int max_h = Integer.MIN_VALUE;
		int max_w = Integer.MIN_VALUE;

		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int line = Integer.parseInt(st.nextToken());
			if(direction == 0)
				vertical[line] = true;
			else
				horizon[line] = true;
			
		}
		int width = 0;
		for(int i = 1; i <= w; i++) {
			if(horizon[i]) {
				max_w  = Math.max(max_w, i - width);
				width = i;
			}
			if(i == w)
				max_w  = Math.max(max_w, i - width);
		}
		
		int heigth = 0;
		for(int i = 1; i <= h; i++) {
			if(vertical[i]) {
				max_h  = Math.max(max_h, i - heigth);
				heigth = i;
			}
			if(i == h) {
				max_h  = Math.max(max_h, i - heigth);
			}
		}
		System.out.println(max_w*max_h);			
	}
}
