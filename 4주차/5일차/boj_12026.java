package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] arr = new char[str.length()];
        for(int i=0;i<str.length();i++){
            arr[i] = str.charAt(i);
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]=='O' && arr[j] == 'B' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
                }else if(arr[i] == 'J' && arr[j] == 'O' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
                }else if(arr[i] == 'B' && arr[j] == 'J' && dp[j] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
                }
            }

        }
        System.out.println((dp[n-1] == Integer.MAX_VALUE)?-1:dp[n-1]);



    }
}
