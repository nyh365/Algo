import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[] center = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			center[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(center);
		int[] diff = new int[N - 1];
		for(int i = 0; i < diff.length; i++) {
			diff[i] = center[i + 1] - center[i];
		}
		
		Arrays.sort(diff);
		int result = 0;
		for(int i = 0; i < diff.length - (K - 1); i++) {
			result += diff[i];
		}
		System.out.print(result);
	}
}
