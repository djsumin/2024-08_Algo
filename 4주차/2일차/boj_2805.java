package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //나무의 수
        int m = Integer.parseInt(st.nextToken()); //가져가려고 하는 나무의 길이

        int[] tree = new int[n];
        st = new StringTokenizer(br.readLine());
        int left = 0;

        for(int i=0;i<n;i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);
        int right = tree[n-1];
        while(left <= right){
            int mid = (left+right)/2;
            long sum = 0;
            for(int i=0;i<n;i++){
                if(tree[i] > mid){
                    sum += tree[i] - mid;
                }
            }
            if(sum >= m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }
        System.out.println(right);


    }
}
