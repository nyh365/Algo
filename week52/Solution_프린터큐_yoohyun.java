import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		int NTestCase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < NTestCase; i++){
			LinkedList<int[]> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int find = Integer.parseInt(st.nextToken());			
		
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++){
				queue.offer(new int[] {j, Integer.parseInt(st.nextToken())});
			}
			int count = 0;		
			
			while(!queue.isEmpty()){
				int[] arr = queue.poll();
				boolean ismax = true;
				
				for(int k = 0; k < queue.size(); k++){
					if(arr[1] < queue.get(k)[1]){
						queue.offer(arr);
						for(int j = 0; j < k; j++){
							queue.offer(queue.poll());
						}	
						ismax = false;
						break;
					}
				}
				if(ismax == false){
					continue;
				}
				count++;
				if(arr[0] == find)
					break;
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
