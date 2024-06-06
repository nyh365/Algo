import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main{
	public static class Node implements Comparable<Node>{
		int index, num;

		public Node(int index, int num) {
			this.index = index;
			this.num = num;
		}
		public int compareTo(Node node) {
			return Integer.compare(this.num, node.num) == 0 ? Integer.compare(this.index, node.index) : Integer.compare(this.num, node.num);
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Node[] num = new Node[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	num[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(num);

        int treeH = (int) Math.ceil(Math.log(N) / Math.log(2));
        int[] tree = new int[(int) Math.pow(2, treeH + 1)];
     
        long result = 0;
        for(int i = 0; i < N; i++) {
        	result += getCnt(tree, 1, 0, N - 1, num[i].index, N - 1);
        	update(tree, 1, 0, N - 1, num[i].index);
        }
        System.out.print(result);
	}
	public static void update(int[] tree, int vertex, int left, int right, int target) {
		if(target < left || target > right) return;
		if(left == right) {
			tree[vertex] = 1;
			return;
		}
		
		update(tree, vertex * 2, left, (left + right) / 2, target);
		update(tree, vertex * 2 + 1, (left + right) / 2 + 1, right, target);
		
		tree[vertex] = tree[vertex * 2] + tree[vertex * 2 + 1];
	}
	public static int getCnt(int[] tree, int vertex, int left, int right, int start, int end) {
		if(right < start || left > end) return 0;
		if(start <= left && right <= end) return tree[vertex];
		
		int leftCnt = getCnt(tree, vertex * 2, left, (left + right) / 2, start, end);
		int rightCnt = getCnt(tree, vertex * 2 + 1, (left + right) / 2 + 1, right, start, end);
	
		return leftCnt + rightCnt;
	}
}
