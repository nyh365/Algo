import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        
        int treeH = (int) Math.ceil(Math.log(N) / Math.log(2));
        int[] tree = new int[(int) Math.pow(2, treeH + 1)];
        
        init(num, tree, 1, 1, N);
        
        int M = Integer.parseInt(br.readLine());
        int order, l, r, result;
        for(int query = 0; query < M; query++) {
        	st = new StringTokenizer(br.readLine());
        	order = Integer.parseInt(st.nextToken());
        	
        	if(order == 1) {
        		update(num, tree, 1, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	} else {
        		l = Integer.parseInt(st.nextToken());
        		r = Integer.parseInt(st.nextToken());
        		
        		result = getEvenCnt(tree, 1, 1, N, l, r);
        		sb.append(order == 2 ? result : r - l + 1 - result).append("\n");
        	}
        }
        
        System.out.append(sb);
	}
	public static void init(int[] num, int[] tree, int vertex, int left, int right) {
		if(left == right) {
			tree[vertex] = num[left] % 2 == 0 ? 1 : 0;
		} else {
			init(num, tree, vertex * 2, left, (left + right) / 2);
			init(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right);
			
			tree[vertex] = tree[vertex * 2] + tree[vertex * 2 + 1];
		}
	}
	public static void update(int[] num, int[] tree, int vertex, int left, int right, int target, int value) {
		if(target < left || target > right) return;
		if(left == right) {
			num[target] = value;
			tree[vertex] = num[left] % 2 == 0 ? 1 : 0;
			return;
		}
		
		update(num, tree, vertex * 2, left, (left + right) / 2, target, value);
		update(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right, target, value);
		
		tree[vertex] = tree[vertex * 2] + tree[vertex * 2 + 1];
	}
	
	public static int getEvenCnt(int[] tree, int vertex, int left, int right, int start, int end) {
		if(left > end || right < start) return 0;
		
		if(start <= left && right <= end) return tree[vertex];
		
		int leftCnt = getEvenCnt(tree, vertex * 2, left, (left + right) / 2, start, end);
		int rightCnt = getEvenCnt(tree, vertex * 2 + 1, (left + right) / 2 + 1, right, start, end);
		
		return leftCnt + rightCnt;
	}
}
