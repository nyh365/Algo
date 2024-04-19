import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws Exception{
		int num_of_words;
		String arr[];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		num_of_words = Integer.parseInt(br.readLine());			
		arr = new String[num_of_words];
		
		for(int i = 0; i < num_of_words; i++){
			arr[i] = br.readLine();
		}		
	
		Arrays.sort(arr, new Comparator<String>(){
			public int compare(String s1, String s2){
				if(s1.length() == s2.length()){
					return s1.compareTo(s2);
				}
				else
					return s1.length() - s2.length();
			}
		});

		StringBuilder sb = new StringBuilder();

		sb.append(arr[0]).append('\n');

		for(int i = 1; i < num_of_words; i++){
			if(!arr[i].equals(arr[i-1])){
				sb.append(arr[i]).append('\n');
			}
		}
		System.out.println(sb);
	}
}
