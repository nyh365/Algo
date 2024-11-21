import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++){
			sb.append("#").append(test_case).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;
			boolean network[][] = new boolean[101][101];
			boolean check[] = new boolean[101];
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int i = 1; i <= (size / 2); i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				network[from][to] = true;
			}
			
			Queue<Integer> queue = new LinkedList<>();
			Queue<Integer> queue2 = new LinkedList<>();
			queue.add(start);
			max = start;
			check[start] = true;
			
			while(!queue.isEmpty()) {
				int from = queue.remove();
				for(int i = 1; i < 101; i++) {
					if(network[from][i] && !check[i]) {
						max = Integer.MIN_VALUE;
						queue2.add(i);
						check[i] = true;
					}
				}
				if(queue.isEmpty()) {
					int length = queue2.size();
					for(int i= 0; i < length; i++) {
						int n = queue2.remove();
						queue.add(n);
						max = Math.max(max, n);
					}
				}
			}
			
			sb.append(max).append("\n");
		}
		System.out.print(sb);
	}
}
