import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++){
			queue.add(i);
		}
		while(!queue.isEmpty()){
			for(int i = 1; i <= K-1; i++){
				queue.add(queue.poll());
			}
			sb.append(queue.poll() + ", ");
		}
		sb.delete(sb.length() - 2, sb.length()).append(">");
		System.out.println(sb);
		
	}
}
