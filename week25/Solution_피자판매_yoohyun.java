import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int result;
	static int N;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] pizzaA = new int[A];
		int[] pizzaB = new int[B];
		
		int totalA = 0;
		for(int i = 0; i < A; i++) {
			pizzaA[i] = Integer.parseInt(br.readLine());
			totalA += pizzaA[i];
		}

		int totalB = 0;
		for(int i = 0; i < B; i++) {
			pizzaB[i] = Integer.parseInt(br.readLine());
			totalB += pizzaB[i];
		}
		
		//map을 이용한 모든 누적합 구하기
		ArrayList<int[]> listA = makeSum(pizzaA, totalA);
		ArrayList<int[]> listB = makeSum(pizzaB, totalB);
		
		solve(listA, listB);
		
		System.out.print(result);
	}
	
	public static ArrayList<int[]> makeSum(int[] pizza, int total){
		HashMap<Integer, Integer> map = new HashMap<>();
		int size = pizza.length;
		int sum = 0;
		for(int i = 0; i < size; i++) {
			sum = 0;
			for(int j = 0; j < size - 1; j++) {
				sum += pizza[(i + j) % size];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		
		map.put(total, map.getOrDefault(total, 0) + 1);
		map.put(0, map.getOrDefault(0, 0) + 1);
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int key : map.keySet()) {
			list.add(new int[] {key, map.get(key)});
		}
		
		return list;
	}
	
	public static void solve(ArrayList<int[]> listA, ArrayList<int[]> listB) {
		Collections.sort(listB, (a, b) -> Integer.compare(a[0], b[0]));
		
		int size = listA.size();
		
		int target;
		for(int i = 0; i < size; i++) {
			target = binarySearch(listB, N - listA.get(i)[0]);
			if(target == -1) continue;
			result += listA.get(i)[1] * listB.get(target)[1];
		}
	}
	
	public static int binarySearch(ArrayList<int[]> listB, int target) {
		int start = 0; 
		int end = listB.size() - 1;
		int result = -1;
		int mid;
		int tmp;
		while(start <= end) {
			mid = (start + end) / 2;
			tmp = listB.get(mid)[0];
			if(target == tmp) {
				result = mid;
				break;
			} else if(target < tmp) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}
}
