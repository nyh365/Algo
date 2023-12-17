import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		int cursor = 0;

		while(N-- > 0){
			int K = Integer.parseInt(br.readLine());
			if(cursor < K ){
				for(int i = cursor + 1; i <= K; i++){
					stack.push(i);
					sb.append("+").append("\n");
				}
				cursor = K;
			}
			else if(stack.peek() != K){
				System.out.println("NO");
				return;				
			}		
			stack.pop();
			sb.append("-").append("\n");	
		}
		System.out.println(sb);				
	}
}
