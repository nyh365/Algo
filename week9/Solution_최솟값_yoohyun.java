import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static long min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] num = new long[N];
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree_N = (int) Math.pow(2, h + 1);
		
		long[] minTree = new long[tree_N];
		
		minInit(num, minTree, 1, 0, N - 1);
		for(int i = 0; i < M; i++){
			min = Long.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			findMinValue(minTree, 1, 0, N - 1, a-1, b-1);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	public static void minInit(long[] num, long[] tree, int vertex, int left, int right) {
		if(left == right) {
			tree[vertex] = num[left];
		} else {
			minInit(num, tree, vertex * 2, left, (left + right) >> 1);
			minInit(num, tree, vertex * 2 + 1, ((left + right) >> 1) + 1, right);
			tree[vertex] = Math.min(tree[vertex * 2],  tree[vertex * 2 + 1]);
		}
	}
	
	public static void findMinValue(long[] tree, int vertex, int left, int right, int start, int end) {
		if(left > end || right < start) return;
		if(start <= left && right <= end) {
			min = Math.min(min, tree[vertex]);
		} else {
			findMinValue(tree, vertex * 2, left, (left + right) >> 1, start, end);
			findMinValue(tree, vertex * 2 + 1, ((left + right) >> 1) + 1, right, start, end);
		}
	}
}

