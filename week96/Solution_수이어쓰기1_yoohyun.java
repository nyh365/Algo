import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
	    
        int result = 0, cnt = 1, target = 10;
        for(int i = 1; i <= N; i++) {
        	if(i == target) {
        		cnt++;
        		target *= 10;
        	}
        	result += cnt;
        }
        System.out.println(result);
	}
}
