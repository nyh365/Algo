import java.util.*;
public class Main{
    public static void main(String args[]) {
       Scanner scan = new Scanner(System.in);
       int num  = scan.nextInt();
       int[] a = new int[1001];
       a[1] = 1;
       a[2] = 3;
       for(int i = 3; i <= num; i++) {
    	   a[i] = a[i-1]+2*a[i-2];
    	   a[i] = a[i] % 10007;
       }
       System.out.print(a[num]);
    }
}
