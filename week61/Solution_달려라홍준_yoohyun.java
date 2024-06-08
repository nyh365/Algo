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
        int M = Integer.parseInt(st.nextToken());
        int[] light = new int[N + 1]; 
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
        	light[i] = Integer.parseInt(st.nextToken());
        }
        
        int treeH = (int) Math.ceil(Math.log(N + 1) / Math.log(2));
        int[] tree = new int[(int) Math.pow(2, treeH + 1)];

        init(light, tree, 1, 1, N);
        
        for(int i = M; i <= N - M + 1; i++) {
        	sb.append(getLight(tree, 1, 1, N, i - (M - 1), i + (M - 1))).append("\n");
        }
        
        System.out.print(sb);
	}
	public static void init(int[] num, int[] tree, int vertex, int left, int right) {
		if(left == right) {
			tree[vertex] = num[left];
		} else {
			init(num, tree, vertex * 2, left, (left + right) / 2);
			init(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right);
			
			tree[vertex] = Math.max(tree[vertex * 2], tree[vertex * 2 + 1]);
		}
	}
	public static int getLight(int[] tree, int vertex, int left, int right, int start, int end) {
		if(right < start || left > end) return 0;
		if(start <= left && right <= end) return tree[vertex];
		
		int leftLight = getLight(tree, vertex * 2, left, (left + right) / 2, start, end);
		int rightLight = getLight(tree, vertex * 2 + 1, (left + right) / 2 + 1, right, start, end);
		
		return Math.max(leftLight, rightLight);
	}
}
