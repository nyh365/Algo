import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Main{
	public static void main (String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[] num = new int[7];
    	
    	for(int i = 1; i <= 6; i++) {
    		num[i] = Integer.parseInt(br.readLine());
    	}

    	int result = num[6];
    	
    	result += num[5];
    	num[1] -= 11 * num[5];
    	
    	result += num[4];
    	num[2] -= 5 * num[4];
    	num[1] += Math.min(num[2], 0) * 4;
    	num[2] = Math.max(num[2], 0);

    	result += num[3] / 4;
    	if(num[3] % 4 != 0) {
    		result += 1;
    		num[2] -= (3 - num[3] % 4) * 2 + 1;
    		num[1] -= 36 - ((3 - num[3] % 4) * 2 + 1) * 4 - (num[3] % 4 * 9);
    		num[1] += Math.min(num[2], 0) * 4;
    	}
    	
    	int temp = Math.max(num[2], 0) + Math.max(num[1], 0) / 4;
    	temp += Math.max(num[1], 0) % 4 == 0 ? 0 : 1;  
    	if(temp > 0) {
    		result += (temp - 1) / 9 + 1;
    	}

    	System.out.print(result);
	}
}
