import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st;
		for(int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#").append(test_case).append(" ");
			br.readLine();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			while(true) {
				boolean flag = false;
				for(int i = 1; i <= 5; i++) {
					int num = queue.remove();
					if(num - i > 0)
						queue.add(num - i);
					else {
						queue.add(0);
						flag = true;
						break;
					}
				}
				if(flag)
					break;
			}
			while(!queue.isEmpty()) {
				sb.append(queue.remove()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
