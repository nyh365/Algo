import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] num = new int[N];
        char[] temp = br.readLine().toCharArray();
        for(int i = 0; i < N; i++) {
        	num[i] = temp[i] - '0';
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.add(num[0]);
        for(int i = 1; i < N; i++) {
        	if(K > 0) {
        		while(!stack.isEmpty()) {
            		if(K <= 0) break;
            		if(stack.peek() < num[i]) {
            			stack.pop();
            			K--;
            		} else {
            			break;
            		}
            	}
        	}
        	stack.add(num[i]);
        }
        
        for(int i = 0; i < K; i++) {
        	stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        System.out.print(sb.reverse());
    }
}
