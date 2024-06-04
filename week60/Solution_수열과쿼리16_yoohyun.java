import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        num[0] = Integer.MAX_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        
        int treeH = (int) Math.ceil(Math.log(N) / Math.log(2));
        int[] tree = new int[(int) Math.pow(2, treeH + 1)];
        
        init(num, tree, 1, 1, N);
        
        int M = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	if(Integer.parseInt(st.nextToken()) == 1) {
        		update(num, tree, 1, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	} else {
        		sb.append(findMin(num, tree, 1, 1, N, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        	}
        }
        System.out.print(sb);
	}
	public static void init(int[] num, int[] tree, int vertex, int left, int right) {
		if(left == right) {
			tree[vertex] = left;
		} else {
			init(num, tree, vertex * 2, left, (left + right) / 2);
			init(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right);
			
			if(num[tree[vertex * 2]] > num[tree[vertex * 2 + 1]]) {
				tree[vertex] = tree[vertex * 2 + 1];
			} else {
				tree[vertex] = tree[vertex * 2]; 
			}
		}
	}
	public static int findMin(int[] num, int[] tree, int vertex, int left, int right, int start, int end) {
		if(left > end || right < start) return 0;
		else if(left >= start && right <= end) {
			return tree[vertex];
		} else {
			int leftIndex = findMin(num, tree, vertex * 2, left, (left + right) / 2, start, end);
			int rightIndex = findMin(num, tree, vertex * 2 + 1,(left + right) / 2 + 1, right, start, end);
			
			if(num[leftIndex] > num[rightIndex]) {
				return rightIndex;
			} else {
				return leftIndex;
			}
		}
	}
	public static void update(int[] num, int[] tree, int vertex, int left, int right, int target, int value) {
		if(target < left || target > right) return;
		else if(left == right) {
			num[target] = value;
			tree[vertex] = target;
			return;
		} else {
			update(num, tree, vertex * 2, left, (left + right) / 2, target, value);
			update(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right, target, value);
			
			if(num[tree[vertex * 2]] > num[tree[vertex * 2 + 1]]) {
				tree[vertex] = tree[vertex * 2 + 1];
			} else {
				tree[vertex] = tree[vertex * 2]; 
			}
		}
	}
}
