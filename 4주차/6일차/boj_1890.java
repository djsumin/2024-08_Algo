package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static int[][] dp; //경로의 개수가 적힌 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }//input

        dp[0][0] = 1;
        jump();

    }

    private static void jump() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j] == 0){
                    continue;
                }
                if(i==n-1 && j==n-1){
                    break;
                }
                //오른쪽으로 갈 때 범위 내인지 검사
                if(arr[i][j] + i < n){
                    dp[arr[i][j] + i][j] += dp[i][j];
                }

                //아래로 점프할 때 범위 내인지 검사
                if(arr[i][j] + j < n){
                    dp[i][arr[i][j] + j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
