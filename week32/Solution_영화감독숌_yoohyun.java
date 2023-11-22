import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		int num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());

		int N = 666;
		int count = 1;  

		while(count != num){
			N++;
			if(String.valueOf(N).contains("666")){
				count++;
			}			
		}
		System.out.println(N);
	}
}
