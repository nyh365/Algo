import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] words;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		long[] num = new long[N];
		for(int i = 0; i < N; i++) {
			num[i] = Long.parseLong(br.readLine());
		}
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree_N = (int) Math.pow(2, h + 1);
		long[] tree = new long[tree_N];
		init(num, tree, 1, 0, N - 1);
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			
			if(order == 1) {
				Long n2 = Long.parseLong(st.nextToken());
				update(num, tree, 1, 0, N-1, n1-1, n2);
			} else {
				int n2 = Integer.parseInt(st.nextToken());
				sb.append(sum(tree, 1, 0, N - 1, n1 - 1, n2 - 1)).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	public static void init(long[] num, long[] tree, int vertex, int left, int right) {
		if(left == right) {
			tree[vertex] = num[left];
		} else {
			init(num, tree, vertex * 2, left, (left + right) / 2);
			init(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right);
			tree[vertex] = tree[vertex * 2] + tree[vertex * 2 + 1];
		}
	}
	public static long sum(long[] tree, int vertex, int left, int right, int start, int end) {
		if(left > end || start > right) return 0;
		else if (start <= left && right <= end) {
			return tree[vertex];
		} else {
			long lsum = sum(tree, vertex * 2, left, (left + right) / 2, start, end);
			long rsum = sum(tree, vertex * 2 + 1 , (left + right) / 2 + 1, right, start, end);
			return lsum + rsum;
		}
	}
	public static void update(long[] num, long[] tree, int vertex, int left, int right, int index, long val) {
		if(index < left || index > right) return;
		else if (left == right) {
			num[index] = val;
            tree[vertex] = val;
            return;
		} else {
			update(num, tree, vertex*2, left, (left + right)/2, index, val);
	        update(num, tree, vertex*2+1, (left + right)/2+1, right, index, val);
	        tree[vertex] = tree[vertex*2] + tree[vertex*2+1];
		}
	}
}
