import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
	    
        int[] num = new int[10];
        int tmp;
        for(; N > 0; N /= 10) {
        	tmp = N % 10;
        	
        	if(tmp == 6 || tmp == 9) {
        		if(num[6] > num[9]) {
        			num[9]++;
        		} else {
        			num[6]++;
        		}
        	} else {
        		num[tmp]++;
        	}
        }
        
        Arrays.sort(num);
        
        System.out.print(num[9]);
	}
}
