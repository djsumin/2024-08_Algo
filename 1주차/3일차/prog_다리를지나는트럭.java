import java.util.*;
import java.io.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; //시간
        int total_weight = 0; //무게
        
        Queue<Integer> queue = new LinkedList<>();
            
        for(int i = 0;i<truck_weights.length;i++){
            int truck = truck_weights[i];
            
            while(true){
                if(queue.isEmpty()){
                    queue.add(truck);
                    total_weight += truck;
                    answer++;
                    break;
                } else if (queue.size() == bridge_length){
                    total_weight -= queue.poll();
                } else {
                  if(total_weight + truck > weight){
                      answer++;
                      queue.add(0);
                  }else{
                      queue.add(truck);
                      answer++;
                      total_weight += truck;
                      break;
                  }
                }
                    
            }

        }
        return answer + bridge_length;
    }
}
