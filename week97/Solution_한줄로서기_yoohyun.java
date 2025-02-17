import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int[] tallCnt = new int[N];
        ArrayList<Integer> result = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	tallCnt[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = N - 1; i >= 0; i--) {
        	result.add(tallCnt[i], i + 1);
        }
        
        for(Integer num : result) {
        	sb.append(num).append(" ");
        }
        System.out.print(sb);
	}
}
