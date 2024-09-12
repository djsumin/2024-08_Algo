package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m,s;
    static int[] v;
    static boolean[][] dp;
    //dp[곡의순서][볼륨]
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        v = new int[n+1];
        dp = new boolean[n+1][m+1];
        dp[0][s] = true;
        
        for(int i=1;i<=n;i++){
            v[i] = Integer.parseInt(st.nextToken());
            for(int j=0;j<=m;j++){
                if(dp[i-1][j]){
                    int plus = j + v[i];
                    int minus = j - v[i];
                    if(plus <= m) dp[i][plus] = true;
                    if(minus >= 0) dp[i][minus] = true;
                }
            }
        }
        int ans = -1;
        for(int i=m;i>=0;i--){
            if(dp[n][i]){
                ans = i;
                break;
            }
        }
        System.out.println(ans);


    }
}
