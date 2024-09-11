package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        long left = 1;

        for(int i=0;i<k;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long right = arr[k-1];
        while(left <= right){
            long mid = (left+right)/2;
            long sum = 0;
            for(int i=0;i<k;i++){
                sum += arr[i]/mid;
            }
            if(sum >= n){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        System.out.println(right);


    }
}
