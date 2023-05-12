import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static List<int[]> house;
	static List<int[]> chicken;
	static int[] order;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] street = new int[N][N];
		int final_result = Integer.MAX_VALUE;
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				street[i][j] = Integer.parseInt(st.nextToken());
				if(street[i][j] == 1) {
					house.add(new int[]{i , j});
				}
				else if(street[i][j] == 2) {
					chicken.add(new int[]{i , j});
				}
			}
		}
		
		order = new int[chicken.size()];
		for(int i = chicken.size() - 1; i > chicken.size() - 1 - M; i--) {
			order[i] = 1;
		}
		
		do {
			final_result = Math.min(final_result, distance());
		}while(next_permutation(order));
		
		System.out.println(final_result);
		
	}
	public static int distance() {
		int result = 0;
		for(int i = 0; i < house.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < chicken.size(); j++) {
				if(order[j] == 1) {
					int length = Math.abs(chicken.get(j)[0] - house.get(i)[0]) + Math.abs(chicken.get(j)[1] - house.get(i)[1]); 
					min = Math.min(min, length);
				}
			}
			result += min;
		}
		return result;
	}
	// 조합을 통해 M개의 치킨 집 정하기
	public static boolean next_permutation(int[] order) {
		int N = order.length;
		int i = N - 1;
		while(i > 0 && order[i-1] >= order[i]) --i;
		if(i == 0) return false;
		
		int j = N - 1;
		while(order[i - 1] >= order[j]) --j;
		
		swap(order, i - 1, j);
		
		int k = N - 1;
		while(i < k) {
			swap(order, i++, k--);
		}
		
		return true;
	}
	public static void swap(int[] order, int i, int j) {
		int tmp = order[i];
		order[i] = order[j];
		order[j] = tmp;
	}
	
}
