import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] num = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.print(next_permutation(num));
	}
	public static String next_permutation(int[] num) {
		int i = num.length - 1;
		
		while(i > 0 && num[i] >= num[i - 1]) {
			i--;
		}
		
		if(i == 0) return "-1";
		
		int j = num.length - 1;
		
		while(num[j] >= num[i - 1]) {
			j--;
		}
		
		swap(num, i - 1, j);
		
		j = num.length - 1;
		while(i < j) {
			swap(num, i++, j--);
		}
		
		return print(num);
	}
	public static void swap(int[] num, int x, int y) {
		int tmp = num[x];
		
		num[x] = num[y];
		num[y] = tmp;
	}
	
	public static String print(int[] num) {
		StringBuilder sb = new StringBuilder();
		
		for(int n : num) {
			sb.append(n).append(" ");
		}
		
		return sb.toString();
	}
}
