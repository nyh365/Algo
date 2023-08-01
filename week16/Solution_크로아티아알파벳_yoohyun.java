import java.util.*;

public class Main{
	public static String replaceTo(String s, String alp){
		return s.replaceAll(alp, "-");
	}
	public static void main(String[] args){
		String[] croAlp = new String[]{"dz=", "z=", "c=", "c-", "d-", "lj", "nj", "s="};
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		int cnt = 0;
		int result = 0;
		
		for(int i = 0; i < croAlp.length; i++){
			int startIdx = 0;
			while(true){
				if((startIdx=s.indexOf(croAlp[i],startIdx)) > -1){
						result ++;
						startIdx++;
								
				}
				else
					break;
			}
			s = replaceTo(s, croAlp[i]);
		}

		for(int i = 0; i< s.length(); i++){
			if(s.charAt(i) != '-')
				result++;
		}

		System.out.println(result);
		
	}	
}

