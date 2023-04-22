import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		Long centi = Long.parseLong(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		int count  = 0; boolean flag = false;
		PriorityQueue<Integer> height = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			height.add(Integer.parseInt(br.readLine()));
		}
		
		while(limit-- > 0) {
			int n = height.poll();
			if(n < centi) {
				height.add(n);
				flag = true;
				break;
			}  
			else{
				if(n == 1) height.add(n);
				else height.add(n / 2);
				count++;
			}
		}
		
		int n = height.poll();
		if(n < centi) {
			flag = true;
		}  
		
		if(flag) {
			System.out.println("YES");
			System.out.println(count);
		}
		else {
			System.out.println("NO");
			System.out.println(n);
		}
	}
}
