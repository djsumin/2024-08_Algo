package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc = 0; tc<T;tc++){
            int n = sc.nextInt(); //문서의 개수
            int m = sc.nextInt(); //몇번째로

            Queue<int[]> queue = new LinkedList<>();
            for(int j =0;j<n;j++){
                int num = sc.nextInt();
                queue.add(new int[]{j, num});
            }
            int cnt = 0;
            while(true){
                int[] arr = queue.poll();
                boolean check = true; //중요한애

                for(int[] arr2 : queue){
                    if(arr2[1] > arr[1]){
                        check = false;
                        break;
                    }
                }

                if(check){
                    cnt++;
                    if(arr[0] == m){
                        break;
                    }
                }else{
                    queue.add(arr);
                }

            }

            System.out.println(cnt);


        }

    }
}
