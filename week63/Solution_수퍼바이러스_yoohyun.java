import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken()) * 10;
            
        System.out.print((K * pow(P, N)) % MOD);    
    }
    public static long pow(long p, long N){
        if(N == 1){
            return p;
        }

        long temp = pow(p, N / 2);
        if(N % 2 == 0){
            return (temp * temp) % MOD;
        } else {
            return ((temp * temp) % MOD * p) % MOD;
        }
    }
}
