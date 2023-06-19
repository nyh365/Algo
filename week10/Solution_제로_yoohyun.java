import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = 0; i < n; i++){
			int num = Integer.parseInt(br.readLine()); 
			if( num == 0){
				stack.pop();
			}
			else{
				stack.push(num);	
			}			
		}
		while(!stack.empty()){
			result += stack.pop();	
		}			
		System.out.println(result);		
	}
}
