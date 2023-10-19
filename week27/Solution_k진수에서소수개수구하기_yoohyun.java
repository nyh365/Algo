class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] tmp = Integer.toString(n, k).split("0");
        
        for(String input : tmp){
            if("".equals(input)) continue;
            if(isPrime(Long.parseLong(input))) answer++;
        }
        return answer;
    }
    boolean isPrime(long n){
        if(n == 1) return false;
        if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
