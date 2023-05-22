import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		long[] num = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		} 
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree_N = (int) Math.pow(2, h + 1);
		long[] tree = new long[tree_N];
		
		init(num, tree, 1, 0, N - 1);
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(order == 1) {
				update(num, tree, 1, 0, N-1, a - 1, b);
			} else {
				sb.append(findMin(tree, 1, 0, N - 1, a - 1, b - 1)).append("\n");
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
			tree[vertex] = Math.min(tree[vertex * 2], tree[vertex * 2 + 1]);
		}
	}
	public static long findMin(long[] tree, int vertex, int left, int right, int start, int end) {
		if(left > end || start > right) return Integer.MAX_VALUE;
		else if (start <= left && right <= end) {
			return tree[vertex];
		} else {
			long l = findMin(tree, vertex * 2, left, (left + right) / 2, start, end);
			long r = findMin(tree, vertex * 2 + 1 , (left + right) / 2 + 1, right, start, end);
			return Math.min(l ,r);
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
	        tree[vertex] = Math.min(tree[vertex*2], tree[vertex*2+1]);
		}
	}
}




