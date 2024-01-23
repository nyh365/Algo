import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> left = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int x, y;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			queue.add(y);
		}
		
		int result = 0;
		int tmp1, tmp2;
		boolean flag;
		
		if(N == 1 && queue.peek() == 0) {
			result = 0;
		} else {
			while(!queue.isEmpty()) {
				tmp1 = queue.remove();
				if(left.isEmpty() || left.peek() < tmp1) {
					left.add(tmp1);
					result++;
				} else {
					flag = false;
					while(!left.isEmpty()) {
						if(left.peek() < tmp1) {
							break;
						}
						tmp2 = left.pop();
						
						if(tmp1 == 0 || tmp1 == tmp2) {
							flag = false;
						} else if (tmp2 > tmp1) {
							flag = true;
						}
					}
					if(flag) result++;
					left.add(tmp1);
				}
			}
		}
		
		System.out.print(result);
	}
}
