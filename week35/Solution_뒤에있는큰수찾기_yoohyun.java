import java.util.*;

class Solution {

   public int[] solution(int[] numbers) {

       int[] answer = new int[numbers.length];

       Stack<Integer> stack = new Stack<>();

       

       for(int i = 0; i < numbers.length; i++){

           while(!stack.isEmpty() && numbers[i] > numbers[stack.peek()]){

               answer[stack.peek()] = numbers[i];

               stack.pop();

           }

           stack.add(i);

       }

       

       while(!stack.isEmpty()){

           answer[stack.pop()] = -1;

       }

       

       return answer;

   }

}

