import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
 
public class Main{
	static int N;
	static LinkedList<Long> result = new LinkedList<>();
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        if(N < 10) {
        	System.out.print(N);
        } else {
        	for(int i = 0; i < 10; i++) {
        		solve(i);
        	}
        	Collections.sort(result);
        	
        	System.out.print(result.size() >= N + 1 ? result.get(N) : -1);
        }
	}
	public static void solve(long num) {
		result.add(num);
		
		long temp = num % 10;
		for(int i = 0; i < temp; i++) {
			solve(num * 10 + i);
		}
	}
}
