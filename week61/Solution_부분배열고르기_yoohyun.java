import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main{
	static long result = 0;
	static int N;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        
        A[0] = Integer.MAX_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        }
        
        int treeH = (int) Math.ceil(Math.log(N + 1) / Math.log(2));
        long[][] tree = new long[(int) Math.pow(2, treeH + 1)][2];

        init(A, tree, 1, 1, N);

        getResult(A, tree, 1, N);
        System.out.print(result);
	}
	public static void init(int[] num, long[][] tree, int vertex, int left, int right) {
		if(left == right) {
			tree[vertex][0] = num[left];
			tree[vertex][1] = left;
		} else {
			init(num, tree, vertex * 2, left, (left + right) / 2);
			init(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right);

			tree[vertex][0] = tree[vertex * 2][0] + tree[vertex * 2 + 1][0];
			tree[vertex][1] = num[(int) tree[vertex * 2][1]] < num[(int)tree[vertex * 2 + 1][1]] ? tree[vertex * 2][1] : tree[vertex * 2 + 1][1];
		}
	}
	public static long[] query(int[] num, long[][] tree, int vertex, int left, int right, int start, int end) {
		if(right < start || left > end) return new long[] {0, 0};
		if(start <= left && right <= end) return tree[vertex];
		
		long[] leftValue = query(num, tree, vertex * 2, left, (left + right) / 2, start, end);
		long[] rightValue = query(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right, start, end);
		
		return new long[] {leftValue[0] + rightValue[0], num[(int)leftValue[1]] < num[(int)rightValue[1]] ? leftValue[1] : rightValue[1]};
	}
	public static void getResult(int[] num, long[][] tree, int left, int right) {
		long[] pivot = query(num, tree, 1, 1, N, left, right);
		
		result = Math.max(result, pivot[0] * num[(int)pivot[1]]);
		
		if(left < pivot[1]) {
			getResult(num, tree, left, (int) (pivot[1] - 1));
		}

		if(right > pivot[1]) {
			getResult(num, tree, (int) (pivot[1] + 1), right);
		}
	}
}
