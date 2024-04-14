import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean prime[] = new boolean[10000001];
	public static void main(String args[]) throws Exception{
		prime[1] = true;
		for(int i = 2; i < 10000001; i++) {
			if(!prime[i]) {
				for(int j = i * 2; j < 10000001; j += i) {
					prime[j] = true;
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = N;;i++) {
			if(!prime[i] && isPalin(String.valueOf(i))) {
				System.out.print(i);
				break;
			}
		}
		
	}
	public static boolean isPalin(String n) {
		for(int i = 0; i < n.length() / 2 ; i++) {
			if(n.charAt(i) != n.charAt(n.length() - 1 - i))
				return false;
		}
		return true;
	}
}
