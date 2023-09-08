class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int sum = 0; int start = 1; int end = 1;
        while(end <= n + 1){
            if(sum > n){
                sum -= start;
                start++;
            } else if(sum <= n){
                sum += end++;
            }
            
            if(sum == n){
                answer++;
            }
        }
        return answer;
    }
}
