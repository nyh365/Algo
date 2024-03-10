import java.io.*;
import java.util.*;

public class Main {
	
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2) -> {
			return n2 - n1;
		});
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				q.add(Integer.parseInt(st.nextToken()));
		}
		for(int i = 0; i < N - 1;i++) {
			q.poll();
		}
		System.out.print(q.poll());
	}
}
