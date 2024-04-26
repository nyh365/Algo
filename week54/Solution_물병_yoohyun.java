import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int result = 0;
		int water = 0;
		
		for(int i = 0; i < N; i++) {
			water += 1;
		}
		
		while(Integer.bitCount(water) > K) {
			water += 1;
			result++;
		}
		System.out.println(result); 
	}
}
