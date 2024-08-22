package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            String bracket = sc.next();
            sb.append(solution(bracket)).append('\n');
        }


    }

    private static String solution(String bracket) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char x : bracket.toCharArray()){
            if(x=='('){
                stack.push(x);
            }else {
                if(stack.isEmpty()){
                    return "NO";
                }else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            return "NO";
        }
        return answer;
    }
}
