import java.io.*;
import java.util.*;

public class Main {
	public static int[] d;
	public static int go(int n) {
		if(d[n] != Integer.MAX_VALUE)
			return d[n];
		d[n] = go(n-1) + 1;
		if(n % 3 == 0) {
			int temp = go(n/3) + 1;
			if(temp < d[n])
			d[n] = temp;
		}
		if(n % 2 == 0) {
			int temp = go(n/2) + 1;
			if(temp < d[n])
			d[n] = temp;
		}
		return d[n];
	}
    public static void main(String args[]) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int num  = Integer.parseInt(br.readLine());
       d = new int[num+1];
       Arrays.fill(d, Integer.MAX_VALUE);
       d[0] = 0; d[1] = 0;
	   System.out.print(go(num));
    }
}
