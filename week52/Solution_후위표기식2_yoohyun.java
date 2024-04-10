import java.io.*;
import java.util.*;

public class Main {
	
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		double sum = 0;
		double[] arr = new double[27];
		Stack<Double> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			double first;
			double second;
			if(c >= 'A' && c <= 'Z') {
				stack.push(arr[c-'A']);
			}
			else {
				second = stack.pop();
				first = stack.pop();
				switch(c){
					case '+':
						stack.push(first + second);
						break;
					case '-':
						stack.push(first - second);
						break;
					case '*':
						stack.push(first * second);
						break;
					case '/':
						stack.push(first / second);
						break;
				}
			}
		}
		System.out.printf("%.2f",stack.pop());
	}
}
