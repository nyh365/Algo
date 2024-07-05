import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        solve(N, "");
    }
    public static void solve(int N, String result) {
    	if(result.length() == N) {
    		System.out.print(result);
    		System.exit(0);
    	}
    	
    	for(int i = 1; i <= 3; i++) {
    		if(!check(result + i)) continue;
    		solve(N, result + i);
    	}
    }
    public static boolean check(String result) {
    	int size = result.length() / 2;
    	int resultSize = result.length();
    	for(int i = 1; i <= size; i++) {
    		if(result.substring(resultSize - i).equals(result.substring(resultSize - i * 2, resultSize - i))) {
    			return false;
    		}
    	}
    	return true;
    }
}
