import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String arr[] = new String[input.length()];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = input.substring(i);
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}
	
}
