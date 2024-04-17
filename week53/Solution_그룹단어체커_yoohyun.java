import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int freq = sc.nextInt();
		String flush = sc.nextLine();
		int result = freq;
		
		

		for(int i =0; i < freq; i++){
			int[] alp = new int[26];
			String s = sc.nextLine();
			char prev =' ';
			for(int j = 0; j < s.length(); j++){
				if(s.charAt(j) != prev){
					if(alp[s.charAt(j)-'a'] >= 1){
						result--;
						break;
					}
				else{
						alp[s.charAt(j)-'a']++;
						prev = s.charAt(j);
					}
				}
			}										
		}
			
		System.out.println(result);
		
	}	
}
