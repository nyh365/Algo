class Solution {
    public int solution(int[] a) {
        int answer = 0;

        int size = a.length;

        if(size == 1) return answer = 1;
        else if(size == 2) return answer = 2;

        answer = 2; 
        size -= 1;

        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;

        int[] min = new int[size + 1];
        for(int i = size; i >= 0; i--){
            rightMin = Math.min(rightMin, a[i]);
            min[i] = rightMin;
        }

        for(int i = 1; i < size; i++){
            leftMin = Math.min(leftMin, a[i - 1]);

            if(leftMin < a[i] && min[i + 1] < a[i]) continue;
            answer++;
        }

        return answer;
    }
}
