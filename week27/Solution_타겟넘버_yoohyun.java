class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers.length, numbers, target);
        return answer;
    }
    void dfs(int cur, int curIdx, int length, int[] numbers, int target){
        if(curIdx == length){
            if(cur == target){
                answer++;
            }
            return;
        }
        dfs(cur - numbers[curIdx], curIdx + 1, length, numbers, target);
        dfs(cur + numbers[curIdx], curIdx + 1, length, numbers, target);
    }
}
