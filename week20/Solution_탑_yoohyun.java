import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) {
				sb.append("0").append(" ");
				stack.add(new int[] {num, i});
			}
			else {
				while(!stack.isEmpty()) {
					if(stack.peek()[0] < num) {
						stack.pop();
					}
					else {
						sb.append(stack.peek()[1] + 1).append(" ");
						break;
					}
					if(stack.isEmpty()) {
						sb.append(0).append(" ");
						break;
					}
				}
				stack.add(new int[] {num, i});
			}
		}
		System.out.println(sb);
	}
}
