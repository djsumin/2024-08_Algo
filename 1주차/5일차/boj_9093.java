package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int num = st.countTokens();

            for(int j=0;j<num;j++){
                String word = st.nextToken();
                Stack<Character> stack = new Stack<>();

                for(int k=0;k<word.length();k++){
                    stack.push(word.charAt(k));
                }

                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }

                if(j < num - 1){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }

    }
}
