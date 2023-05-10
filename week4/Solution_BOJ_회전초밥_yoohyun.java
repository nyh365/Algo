import java.io.*;
import java.util.*;

public class Main {
	static int[] eat;
	static int[] sushi;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        eat = new int[d + 1];
        sushi = new int[N];
        for(int i = 0; i < N; i++) {
        	sushi[i] = Integer.parseInt(br.readLine());
        }
       
        int count = 0;
        for(int i = 0; i < k; i++) {
        	if(eat[sushi[i]] == 0)
        		count++;
        	eat[sushi[i]]++;
        }
        int result = count;
        
        for(int i = 1; i < N; i++) {
        	eat[sushi[i-1]]--;
        	if(eat[sushi[i-1]] == 0) count--;
        	if(eat[sushi[(i + k - 1) % N]] == 0) count++;
        	eat[sushi[(i + k - 1) % N]]++;
        	if(eat[c] == 0) {
        		result = Math.max(result, count + 1);
        	}
        	else {
        		result = Math.max(result, count);
        	}
        }
        
        System.out.println(result);
    }
}
