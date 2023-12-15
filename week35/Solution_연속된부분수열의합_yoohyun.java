class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int length = Integer.MAX_VALUE;
        int index = Integer.MAX_VALUE;
        
        int start = 0, end = 0, tmp = 0, sum = 0;
        int size = sequence.length;
        while(end <= size && start < size){
            if(sum < k){
                if(end < size){
                        sum += sequence[end]; 
                }
                end++;
            } else if(sum > k){
                sum -= sequence[start++];
            }
            if(sum == k){
                tmp = end - start;
                if(tmp == length){
                    if(start < index){
                        index = start;
                    }
                } else if(tmp < length){
                    length = tmp;
                    index = start;
                }
                if(end < size){
                    sum += sequence[end];    
                }
                end++;
            }
        }
        answer[0] = index;
        answer[1] = index + length - 1;
        return answer;
    }
}
