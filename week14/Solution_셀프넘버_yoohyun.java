import java.util.*;

public class Main{
	public static int fn1(int n){
		int result = 0;
		result += n;
		for(; n > 0; n /= 10){
			result += n % 10;
		}	
		return result;
	} 
	public static void main(String[] args){
		int[] dn = new int[10001];
		for(int i = 1; i <= 10000; i++){
			if(fn1(i) <= 10000)
				dn[fn1(i)]++;
		}
		for(int i = 1; i<= 10000; i++){
			if(dn[i] == 0)
				System.out.println(i);	
		}	
	}
}
