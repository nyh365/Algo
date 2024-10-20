import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			char arr[] = br.readLine().toCharArray();
			long result = 1;
			if(arr.length == 1)
				result = 1 ;
			else {
				for(int i = 0; i < arr.length; i++) {
					if(i == 0) {
						if(arr[i] == arr[i + 1])
							result *= 1;
						else
							result *= 2;
					}
					else if(i == arr.length -1) {
						if(arr[i] == arr[i - 1])
							result *= 1;
						else
							result *= 2;
					}
					else{
						if(arr[i] == arr[i - 1] && arr[i - 1] == arr[i + 1])
							result *= 1;
						else if(arr[i] != arr[i - 1] && arr[i - 1] != arr[i + 1] && arr[i] != arr[i + 1])
							result *= 3;
						else 
							result *= 2;
					}
					result %= (Math.pow(10, 9) + 7);
				}
			}
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}
