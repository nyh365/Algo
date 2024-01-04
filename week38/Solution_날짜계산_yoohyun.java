import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int year;
		
		for(int i = 0;; i++) {
			if((i % 15 + 1 == E) && (i % 28 + 1 == S) && (i % 19 + 1 == M)) {
				year = i + 1;
				break;
			}
		}
		System.out.print(year);
	}
}
