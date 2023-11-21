import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		long[] num = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Long.parseLong(st.nextToken());
		} 
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int tree_N = (int) Math.pow(2, h + 1);
		long[] tree = new long[tree_N];
		
		init(num, tree, 1, 0, N - 1);
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(x > y) {
				int tmp = x;
				x = y;
				y = tmp;
			}
			sb.append(sum(tree, 1, 0, N - 1, x - 1, y - 1)).append("\n");
			update(num, tree, 1, 0, N-1, a - 1, b);
			
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
