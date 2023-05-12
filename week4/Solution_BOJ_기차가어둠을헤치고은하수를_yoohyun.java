import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] trains = new int[N + 1];
		HashSet<Integer> s = new HashSet<>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int train = -1; int line = -1;
			train = Integer.parseInt(st.nextToken());
			switch(order) {
			case 1 :
				line = Integer.parseInt(st.nextToken()) -1;
				trains[train] = trains[train] | (1 << line);
				break;
			case 2 : 
				line = Integer.parseInt(st.nextToken()) -1;
				trains[train] = trains[train] & (~(1 << line));
				break;
			case 3 : 
				trains[train] <<= 1;
				trains[train] &= (1 << 20) -1;
				break;
				
			case 4 : 
				trains[train] >>= 1;
				break;
			}
		}
		for(int i = 1; i <= N; i++) {
			s.add(trains[i]);
		}
		System.out.println(s.size());
	}
}
