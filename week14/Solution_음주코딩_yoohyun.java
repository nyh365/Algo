import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		while((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			char[] num = new char[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				int n = Integer.parseInt(st.nextToken());
				if(n > 0) num[i] = '+';
				else if(n == 0) num[i] = '0';
				else num[i] = '-';
			} 
			
			int h = (int) Math.ceil(Math.log(N) / Math.log(2));
			int tree_N = (int) Math.pow(2, h + 1);
			char[] tree = new char[tree_N];
			
			init(num, tree, 1, 0, N - 1);
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				String order = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(order.equals("C")) {
					update(num, tree, 1, 0, N-1, a - 1, b);
				} else {
					sb.append(findMin(tree, 1, 0, N - 1, a - 1, b - 1));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void init(char[] num, char[] tree, int vertex, int left, int right) {
		if(left == right) {
			tree[vertex] = num[left];
		} else {
			init(num, tree, vertex * 2, left, (left + right) / 2);
			init(num, tree, vertex * 2 + 1, (left + right) / 2 + 1, right);
			if(tree[vertex * 2] == '0' | tree[vertex * 2 + 1] == '0')
				tree[vertex] = '0';
			else if(tree[vertex * 2] == tree[vertex * 2 + 1])
				tree[vertex] = '+';
			else {
				tree[vertex] = '-';
			}
		}
	}
	public static char findMin(char[] tree, int vertex, int left, int right, int start, int end) {
		if(left > end || start > right) return '+';
		else if (start <= left && right <= end) {
			return tree[vertex];
		} 
		else {
			char l = findMin(tree, vertex * 2, left, (left + right) / 2, start, end);
			char r = findMin(tree, vertex * 2 + 1 , (left + right) / 2 + 1, right, start, end);
			
			if(l == '0' | r == '0')
				return '0';
			if(l == r)
				return '+';
			return '-';
		}
	}
	public static void update(char[] num, char[] tree, int vertex, int left, int right, int index, long val) {
		if(index < left || index > right) return;
		else if (left == right) {
			char vval = ' ';
			if(val == 0) vval = '0';
			else if(val > 0) vval = '+';
			else vval = '-';
			num[index] = vval;
            tree[vertex] = vval;
            return;
		} else {
			update(num, tree, vertex*2, left, (left + right)/2, index, val);
	        update(num, tree, vertex*2+1, (left + right)/2+1, right, index, val);
	        if(tree[vertex * 2] == '0' | tree[vertex * 2 + 1] == '0')
				tree[vertex] = '0';
			else if(tree[vertex * 2] == tree[vertex * 2 + 1])
				tree[vertex] = '+';
			else {
				tree[vertex] = '-';
			}
		}
	}
}




