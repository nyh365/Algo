import java.io.*;
import java.util.*;


public class Main {
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long max = Integer.MIN_VALUE;
		tree = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			tree[i] = Long.parseLong(st.nextToken());
			max = Math.max(max, tree[i]);
		}

		long s = 1; 
		long e = max ; 
		long mid;
		while (s < e) { 

			mid = (s + e) / 2;
			
			if(cut_tree(mid) < M) {
				e = mid;
			}
			else {
				s = mid + 1;
			}
		}

		System.out.println(s - 1);
	}
	static long cut_tree(long length) {
		long total = 0;
		for(int i = 0; i < tree.length; i++) {
			if(tree[i] - length > 0)
				total += tree[i] - length;
		}
		return total;
	}
}
