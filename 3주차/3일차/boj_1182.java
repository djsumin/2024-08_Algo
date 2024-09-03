package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int n, s;
    static int[] arr;
    static boolean[] visit;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        } //입력끝

        for(int i=1;i<=n;i++)
        {
            comb( 0, i);
            //i가 부분수열의 길이
        }
        System.out.println(cnt);


    }

    private static void comb(int start, int depth) {
        if(depth == 0){
            sum(arr, visit);
        }else{
            for(int i=start;i<n;i++){
                visit[i] = true;
                comb(i+1, depth-1);
                // 이제 더 뽑아야 할 부분수열의 길이는 줄어든다.
                visit[i] = false;
            }
        }


    }

    private static void sum(int[] arr, boolean[] visit) {
        int sum = 0;
        for(int i=0;i<n;i++){
            if(visit[i]){
                sum += arr[i];
            }
        }
        if(sum == s){
            cnt++;
        }
    }
}
