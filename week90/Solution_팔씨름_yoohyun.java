import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		 
		for(int test_case = 1; test_case <= T; test_case++) {
			String s = br.readLine();
			int count = 0;
			int play = s.length();
			String result = "";
			for(int i = 0; i < play; i++) {
				if(s.charAt(i) =='o')
					count++;
			}
			if(15 - play + count < 8)
				result = "NO";
			else 
				result = "YES";
			
			System.out.println("#" + test_case + " " + result);		
		}
	}
}
