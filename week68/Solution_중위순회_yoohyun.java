import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());

			arr = new char[N + 1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				arr[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
			}
			inOrder(1);
			sb.append("\n");
		}
		System.out.print(sb);
	}

	static void inOrder(int index) {
		if(index > N) return;
		
		inOrder(index * 2);
		sb.append(arr[index]);
		inOrder(index * 2 + 1);
	}
}
