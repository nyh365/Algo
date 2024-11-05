import java.io.*;
import java.util.*;

public class Solution{
	static int[][] food;
	public static void main(String arge[]) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			int N = Integer.parseInt(br.readLine());
			food = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = Integer.MAX_VALUE;
			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			// 000...1 ~ 1111..N 까지의 경우 중 1의 개수가 n/2인 경우만 선택하기
			for(int i = 1; i < (1 << N); i++) {
				if(Integer.bitCount(i) == (N / 2)) {
					for(int f = 0; (1 << f) < (1 << N); f++) {
						if((i & (1 << f)) > 0) A.add(f);
						else B.add(f);
					}
					result = Math.min(result, diff(A, B));
					A.clear();
					B.clear();
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	// A음식과 B음식간의 맛의 차이 구하기
	public static int diff(List<Integer> A, List<Integer> B) {
		int sumA = 0, sumB = 0;
		for(int i = 0; i < A.size(); i++) {
			for(int j = i; j < A.size(); j++) {
				sumA += food[A.get(i)][A.get(j)];
				sumA += food[A.get(j)][A.get(i)];
				sumB += food[B.get(i)][B.get(j)];
				sumB += food[B.get(j)][B.get(i)];
			}
		}
		return (int) Math.abs(sumA - sumB);
	}
}
