import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char c;
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if(x1 > p2 || x2 < p1 || y1 > q2 || y2 < q1) c = 'd';
			else if(x1 == p2 || x2 == p1) {
				if(y1 == q2 || y2 == q1) c = 'c';
				else c= 'b';
			}
			else if(y1 == q2 || y2 == q1) {
				if(x1 == p2 || x2 == p1) c= 'c';
				else c = 'b';
			}
			else
				c = 'a';
			System.out.println(c);
		}
		
	}
}
