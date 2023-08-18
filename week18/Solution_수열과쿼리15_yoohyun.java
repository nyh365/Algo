import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] num, segTree;
	static int N;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		num = new int[N + 1];
		num[N] = Integer.MAX_VALUE;
		segTree = new int[4 * N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1, 0, N -1);
		
		int Q = Integer.parseInt(br.readLine());
		int order, targetIdx, value;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			order = Integer.parseInt(st.nextToken());
			if(order == 1) {
				targetIdx = Integer.parseInt(st.nextToken()) - 1;
				value = Integer.parseInt(st.nextToken());
				update(1, targetIdx, 0, N - 1, value);
			} else {
				sb.append(query(1, 0, N - 1, 0, N -1) + 1).append("\n");
			}
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
	
	static void update(int curIdx, int targetIdx, int leftIdx, int rightIdx, int value) {
		if(targetIdx < leftIdx || rightIdx < targetIdx) {
			return;
		}
		
		if(leftIdx == rightIdx) {
			num[leftIdx] = value;
			return;
		}
		
		int mid = (leftIdx + rightIdx) / 2;
		
		update(curIdx * 2, targetIdx, leftIdx, mid, value);
		update(curIdx * 2 + 1,targetIdx,  mid + 1, rightIdx, value);
		
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
		int right = query(curIdx * 2, mid + 1, rightIdx, qLeft, qRight);
		
		return segTree[curIdx] = (num[left] <= num[right] ? left : right );
	}
}




