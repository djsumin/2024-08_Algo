
https://school.programmers.co.kr/learn/courses/30/lessons/154539

문제 설명
정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.

제한사항
4 ≤ numbers의 길이 ≤ 1,000,000
1 ≤ numbers[i] ≤ 1,000,000
입출력 예
numbers	result
[2, 3, 3, 5]	[3, 5, 5, -1]
[9, 1, 5, 3, 6, 2]	[-1, 5, 6, 6, -1, -1]
입출력 예 설명
입출력 예 #1
2의 뒷 큰수는 3입니다. 첫 번째 3의 뒷 큰수는 5입니다. 두 번째 3 또한 마찬가지입니다. 5는 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [3, 5, 5, -1]이 됩니다.

입출력 예 #2
9는 뒷 큰수가 없으므로 -1입니다. 1의 뒷 큰수는 5이며, 5와 3의 뒷 큰수는 6입니다. 6과 2는 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [-1, 5, 6, 6, -1, -1]이 됩니다.

---
처음 풀이로 했는데 시간초과나서 부분 테케가 틀렸다. 알고보니 제한사항에 범위가 백만..
이중 포문을 돌리면 1000000000000번을 최대 계산해야 한다.

```java
import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i=0;i<answer.length;i++){
            for(int j=i+1;j<answer.length;j++){
                if(numbers[i] < numbers[j]){
                    answer[i] = numbers[j];
                    break;
                }else if(numbers[i] >= numbers[j]){
                    answer[i] = -1;
                }
            }
            if(i == answer.length -1){
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}
```

이중포문이 아니라 스택을 사용했다.



```java
import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);
        
        for(int i=1;i<numbers.length;i++){
             while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                 answer[stack.pop()] = numbers[i];
             }
            
            stack.push(i);
        }
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
        
        return answer;
    }
}
```
