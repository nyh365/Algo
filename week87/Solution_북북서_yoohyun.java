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
			String result = "";
			int up = 0, down = 1;
			for(int i = s.length() - 1; i >= 0; i--) {
				char c = s.charAt(i); 
				if( c == 'n') {
					if(count == 0) {
						up = 0;
					}
					else {	
						int tmp = down;
						down = (int) Math.pow(2, count);
						up = up * (down / tmp) - 90;
					}
					count++;
				}
				else if(c == 'w') {
					if(count == 0) {
						up = 90;
					}
					else {
						int tmp = down;
						down = (int) Math.pow(2, count);
						up = up * (down / tmp) + 90;
					}
					count++;
				}
			}
			if(up % down == 0)
				result += (up / down);
			else {
				while(true) {
					if(up % 2 == 0 && down % 2 == 0) {
						up /= 2;
						down /= 2;
					}
					else
						break;
				}
				result += up + "/" + down;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
