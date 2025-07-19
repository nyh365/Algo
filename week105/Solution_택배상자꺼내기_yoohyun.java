class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int remove = (num - 1) / w;
        int numIndex = (num - 1) % w + 1;
        
        int remain = n - remove * w;
        int line = (remain - 1) / w;
        int remainIndex = (remain - 1) % w + 1;
        
        answer += line;
        
        if((remove + 1) % 2 != (remove + line + 1) % 2) {
            answer += (numIndex + remainIndex) > w ? 1 : 0;
        } else {
            answer += (remainIndex >= numIndex) ? 1 : 0; 
        }
        
        return answer;
    }
}
