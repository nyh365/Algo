import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] light = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < light.length; i++)
			light[i] = Integer.parseInt(st.nextToken());
		
		int result = Math.max(light[0], N - light[M - 1]);
		
		for(int i = 1; i < light.length; i++)
			result = Math.max(result, (light[i] - light[i-1] + 1) / 2);
		
		System.out.println(result);
	}
}
