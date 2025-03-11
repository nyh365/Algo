class Solution {
    static final int MOD = 10007;
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        a[1] = 1;
        b[1] = tops[0] == 1 ? 3 : 2;
        
        for(int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + b[i - 1];
        
            if(tops[i - 1] == 1) {
                b[i] = 3 * b[i - 1] + 2 * a[i - 1];
            } else {
                b[i] = 2 * b[i - 1] + a[i - 1];
            }
            
            a[i] %= MOD;
            b[i] %= MOD;
        }
        
        return (a[n] + b[n]) % MOD;
    }
}
