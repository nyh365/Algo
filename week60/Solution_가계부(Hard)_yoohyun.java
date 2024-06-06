import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        long[] num = new long[N + 1];
        int treeH = (int) Math.ceil(Math.log(N) / Math.log(2));
        long[] tree = new long[(int) Math.pow(2, treeH + 1)];
        
        init(tree);
        
        int order, l, r;
        long result = 0L;
        for(int query = 0; query < Q; query++) {
        	st = new StringTokenizer(br.readLine());
        	order = Integer.parseInt(st.nextToken());
        	
        	if(order == 1) {
        		update(num, tree, 1, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	} else {
        		l = Integer.parseInt(st.nextToken());
        		r = Integer.parseInt(st.nextToken());
        		
        		result = getValue(tree, 1, 1, N, l, r);
        		sb.append(result).append("\n");
        	}
        }
        
        System.out.append(sb);
	}
	public static void init(long[] tree) {
		Arrays.fill(tree, 0);
	}
	public static void update(long[] num, long[] tree, int vertex, int left, int right, int target, int value) {
		if(target < left || target > right) return;
		if(left == right) {
			num[target] += value;
			tree[vertex] = num[target];
			return;
		}
		
		update(num, tree, vertex * 2, left, (left + right) / 2, target, value);
		update(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right, target, value);
		
		tree[vertex] = tree[vertex * 2] + tree[vertex * 2 + 1];
	}
	
	public static long getValue(long[] tree, int vertex, int left, int right, int start, int end) {
		if(left > end || right < start) return 0;
		
		if(start <= left && right <= end) return tree[vertex];
		
		long leftValue = getValue(tree, vertex * 2, left, (left + right) / 2, start, end);
		long rightValue = getValue(tree, vertex * 2 + 1, (left + right) / 2 + 1, right, start, end);
		
		return leftValue + rightValue;
	}
}
