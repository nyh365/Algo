import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int MAX = 4000001;
	static boolean prime[] = new boolean[MAX];
	
	public static void main(String args[]) throws Exception{
		ArrayList<Integer> list = new ArrayList<>();
		prime[1] = true;
		for(int i = 2; i < MAX; i++) {
			if(!prime[i]) {
				list.add(i);
				for(int j = i * 2; j < MAX; j += i) {
					prime[j] = true;
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = 0; i < list.size();i++) {
			int sum = 0;
			int tmp1 = list.get(i);
			sum += tmp1;
			if(sum == N) {
				result++;
				continue;
			}
			else {
				for(int j = i + 1; j < list.size();j++) {
					int tmp2 = list.get(j);
					sum += tmp2;
					if(sum > N) break;
					else if(sum == N) {
						result++;
					}
				}
			}
		}
		System.out.print(result);
	}
}
