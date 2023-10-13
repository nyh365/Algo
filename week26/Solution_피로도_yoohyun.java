class Solution {
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        int length = dungeons.length;
        int[] order = new int[length];
        
        for(int i = 0; i <length; i++){
            order[i] = i;
        }
        
        permutation(order, 0, length, length, k, dungeons);
        
        return answer;
    }
    void permutation(int[] order, int dept, int size, int r, int k, int[][] dungeons){
        if(dept == r){
            answer = Math.max(answer, solve(order, k, dungeons));
            return;
        }
        for(int i = dept; i < order.length; i++){
            swap(order, dept, i);
            permutation(order, dept+1, size, r, k, dungeons);
            swap(order, dept, i);
        }
    }
    void swap(int[] order, int dept, int i){
        int tmp = order[dept];
        order[dept] = order[i];
        order[i] = tmp;
    }
    int solve(int[] order, int k, int[][] dungeons){
        int cnt = 0;
        for(int num : order){
            if(k < dungeons[num][0]) continue;
            if(k < dungeons[num][1]) continue;
            cnt++;
            k-= dungeons[num][1];
        }
        return cnt;
    }
}
