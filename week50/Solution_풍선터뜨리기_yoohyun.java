import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<int[]> list = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			list.add(new int[] {i + 1, Integer.parseInt(st.nextToken())});
		}
		
		while(true) {
			int tmp[] = list.pollFirst();
			int cur = tmp[0];
			int move = tmp[1];		
			sb.append(cur + " ");
			
			if(list.isEmpty())
				break;
			
			if(move > 0) {
				for(int i = 0; i < move -1; i++) {
					list.add(list.pollFirst());
				}
			}
			else{
				for(int i = Math.abs(move); i > 0; i--) {
					list.addFirst(list.pollLast());
				}
			}
		}
		System.out.print(sb);
	}
}
