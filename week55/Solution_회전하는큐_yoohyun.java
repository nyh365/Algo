import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> deq = new LinkedList<>();
		int[] find = new int[M];
		
		for(int i = 1; i <= N; i++) {
			deq.add(i);
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		int cur_index = 0; 
		for(int i = 0; i < M; i++) {
			int find_index = deq.indexOf(find[i]);
			
			if (find_index - cur_index >= deq.size() - find_index + cur_index) {
				for(int j = 0; j < deq.size() - find_index + cur_index; j++) {
					deq.addFirst(deq.pollLast());
					result++;
				}
			}
			else {
				for(int j = 0; j < find_index - cur_index; j++) {
					deq.add(deq.pollFirst());
					result++;
				}
			}			
			deq.poll();
		}

		System.out.print(result);
	}
}
