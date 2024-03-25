import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
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
		long[] maxTree = new long[tree_N];
		
		minInit(num, minTree, 1, 0, N - 1);
		maxInit(num, maxTree, 1, 0, N - 1);
		for(int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(findMinValue(minTree, 1, 0, N - 1, a-1, b-1)).append(" ").append(findMaxValue(maxTree, 1, 0, N - 1, a-1, b-1)).append("\n");
		}
		System.out.println(sb);
		
	}
	public static void minInit(long[] num, long[] tree, int vertex, int left, int right) {
		if(left == right) {
			tree[vertex] = num[left];
		} else {
			minInit(num, tree, vertex * 2, left, (left + right) / 2);
			minInit(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right);
			tree[vertex] = Math.min(tree[vertex * 2],  tree[vertex * 2 + 1]);
		}
	}
	
	public static void maxInit(long[] num, long[] tree, int vertex, int left, int right) {
		if(left == right) {
			tree[vertex] = num[left];
		} else {
			maxInit(num, tree, vertex * 2, left, (left + right) / 2);
			maxInit(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right);
			tree[vertex] = Math.max(tree[vertex * 2],  tree[vertex * 2 + 1]);
		}
	}
	
	public static long findMinValue(long[] tree, int vertex, int left, int right, int start, int end) {
		if(left > end || right < start) return Long.MAX_VALUE;
		if(start <= left && right <= end) {
			return tree[vertex];
		}
		long lTree = findMinValue(tree, vertex * 2, left, (left + right) / 2, start, end);
		long rTree = findMinValue(tree, vertex * 2 + 1, (left + right) / 2 + 1, right, start, end);
		return Math.min(lTree, rTree); 
	}
	public static long findMaxValue(long[] tree, int vertex, int left, int right, int start, int end) {
		if(left > end || right < start) return Long.MIN_VALUE;
		if(start <= left && right <= end) {
			return tree[vertex];
		}
		long lTree = findMaxValue(tree, vertex * 2, left, (left + right) / 2, start, end);
		long rTree = findMaxValue(tree, vertex * 2 + 1, (left + right) / 2 + 1, right, start, end);
		return Math.max(lTree, rTree);
	}
}
