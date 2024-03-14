import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {
public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int arr[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		for(int i = 1; i <= N; i++) {
			int temp = arr[N - i] * i;
			max = Math.max(max, temp);
		}
		System.out.println(max);
	}
}
