class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int prev = 1;
        for(int station : stations) {
            if(prev <= station - w - 1) {
                answer += (station - w - prev) / (2 * w + 1);
                answer += (station - w - prev) % (2 * w + 1) == 0 ? 0 : 1;
            }
            
            prev = station + w + 1;
        }
        
        if(prev <= n) {
            answer += (n - prev + 1) / (2 * w + 1);
            answer += (n - prev + 1) % (2 * w + 1) == 0 ? 0 : 1;
        }
        
        return answer;
    }
}
