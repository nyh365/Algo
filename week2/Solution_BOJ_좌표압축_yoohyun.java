import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] tmp = new int[N];
		Map<Integer, Integer> m = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			tmp[i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int index = 0;
		for(int i = 0; i< N; i++) {
			if(!m.containsKey(arr[i])) {
				m.put(arr[i], index);
				index++;
			}
		}
			
		for(int i = 0; i < N; i++) {
			sb.append(m.get(tmp[i])).append(" ");
		}
		System.out.print(sb);
		
	}

}
