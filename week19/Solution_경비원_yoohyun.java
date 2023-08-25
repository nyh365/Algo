import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		
		int result = 0;
		for(int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int store_dir = Integer.parseInt(st.nextToken());
			int store_dis = Integer.parseInt(st.nextToken());
			
			if(store_dir == 4)
				store_dis = W + store_dis;
			else if(store_dir == 2)
				store_dis = 2 * W + H - store_dis;
			else if(store_dir == 3)
				store_dis = 2 * W + 2 * H - store_dis;
			stack.add(store_dis);
		}
		int dis = stack.pop();
		for(int i = 0; i < N; i++) {
			int tmp = Math.abs(stack.pop() - dis);
			result += Math.min(tmp, 2 * W + 2 * H - tmp);
		}
		
		System.out.println(result);

	}
}
