class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        while((a - 1) / 2 != (b - 1) / 2){
            a = (a - 1) / 2 + 1;
            b = (b - 1) / 2 + 1; 
            answer++;
        }  
        return answer;
    }
}
