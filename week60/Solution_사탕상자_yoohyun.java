import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main{
	static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int treeH = (int) Math.ceil(Math.log(MAX + 1) / Math.log(2));
        int[] tree = new int[(int) Math.pow(2, treeH + 1)];
     
        int A, B, C;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());
        	if(A == 1) {
        		sb.append(getFlavor(tree, 1, 1, MAX, B, 0)).append("\n");
        	} else {
        		C = Integer.parseInt(st.nextToken());
        	
        		update(tree, 1, 1, MAX, B, C);
        	}
        }
        System.out.print(sb);
	}
	public static void update(int[] tree, int vertex, int left, int right, int target, int cnt) {
		if(target < left || target > right) return;
		if(left == right) {
			tree[vertex] += cnt;
			return;
		}
		
		update(tree, vertex * 2, left, (left + right) / 2, target, cnt);
		update(tree, vertex * 2 + 1, (left + right) / 2 + 1, right, target, cnt);
		
		tree[vertex] = tree[vertex * 2] + tree[vertex * 2 + 1];
	}
	public static int getFlavor(int[] tree, int vertex, int left, int right, int priority, int total) {
		tree[vertex]--;
		if(left == right) {
			return left;
		}
		if(total + tree[vertex * 2] >= priority) {
			return getFlavor(tree, vertex * 2, left, (left + right) / 2, priority, total);
		} else {
			return getFlavor(tree, vertex * 2 + 1, (left + right) / 2 + 1, right, priority, total + tree[vertex * 2]);
		}
	}
}
