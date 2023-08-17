import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] num, segTree;
	static int N;
	static long result;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) break;
			
			num = new int[N + 1];
			num[N] = Integer.MAX_VALUE;
			segTree = new int[4 * N];
			
			for(int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			init(1, 0, N -1);
			
			result = Long.MIN_VALUE;
			
			solve(0, N - 1);
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
    }
	static void init(int curIdx, int leftIdx, int rightIdx) {
		if(leftIdx == rightIdx) {
			segTree[curIdx] = leftIdx;
			return;
		}
		
		int mid = (leftIdx + rightIdx) / 2;
		
		init(curIdx * 2, leftIdx, mid);
		init(curIdx * 2 + 1, mid + 1, rightIdx);
		
		segTree[curIdx] = (num[segTree[curIdx * 2]] <= num[segTree[curIdx * 2 + 1]] ? segTree[curIdx * 2] : segTree[curIdx * 2 + 1] );
	}
	
	static int query(int curIdx, int leftIdx, int rightIdx, int qLeft, int qRight) {
		if(qRight < leftIdx || rightIdx < qLeft) {
			return N;
		}
		
		if(qLeft <= leftIdx &&  rightIdx <= qRight) {
			return segTree[curIdx];
		}
		
		int mid = (leftIdx + rightIdx) / 2;
		
		int left = query(curIdx * 2, leftIdx, mid, qLeft, qRight);
		int right = query(curIdx * 2 + 1, mid + 1, rightIdx, qLeft, qRight);
		
		return segTree[curIdx] = (num[left] <= num[right] ? left : right );
	}
	
	static void solve(int leftIdx, int rightIdx) {
		
		int minIdx = query(1, 0, N - 1, leftIdx, rightIdx);
		
		result = Math.max(result, num[minIdx] * (long) (rightIdx - leftIdx + 1));
		
		if(minIdx - 1 >= leftIdx) {
			solve(leftIdx, minIdx - 1);
		}
		
		if(minIdx + 1 <= rightIdx) {
			solve(minIdx + 1, rightIdx);
		}
	}
}




