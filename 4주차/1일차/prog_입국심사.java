import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        long left = times[0];
        long right = (long)times[times.length-1]*(long)n; //모든 사람이 가장 긴 시간으로 입국 심사 받을 때
        
        while(left <= right){
            long mid = (left + right) /2;
            long sum = 0;
            for(int x:times){
                sum += mid/x;
                //중간값의 시간동안 몇명의 사람 처리 가능?
            }
            if(sum<n){
                left = mid + 1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }
        
        
        
        return answer;
    }
}
