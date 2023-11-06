import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int sum = 0;
		int arr[] = new int[N];
		int i = 0;
		for(Integer key : map.keySet()) {
			arr[i] = key;
			i++;
		}
		
		int max = Integer.MIN_VALUE;
		int front_index = -1;
		int back_index = -1;
		for(int j = 0 ; j < N; j++) {
			if(map.get(arr[j]) > max) {
				front_index = j;
				max = map.get(arr[j]);
			}
		}
		for(int j = front_index; j < N; j++) {
			if(map.get(arr[j]) >= max) {
				back_index = j;
			}
		}
		
		int start = arr[0];
		for(int j = 0; j < front_index; j++) {
			if(map.get(arr[j+1]) >= map.get(start)) {
				int width = arr[j+1] - start;
				int heigh = map.get(start);
				sum += width * heigh;
				start = arr[j+1];
			}
		}
		
		start = arr[N - 1];
		for(int j = N -1; j > back_index; j--) {
			if(map.get(arr[j-1]) >= map.get(start)) {
				int width = start - arr[j - 1];
				int heigh = map.get(start);
				sum += width * heigh;
				start = arr[j - 1];
			}
		}
		
		sum += map.get(arr[front_index]) * (arr[back_index] - arr[front_index] + 1 );
		 
		
		System.out.print(sum);
	}
}
