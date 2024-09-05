
package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int ans =0;
    static int[][] arr = new int[6][3];
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 0;tc<4;tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ans =0;
            for(int i=0;i<18;i++){
                arr[i/3][i%3] = Integer.parseInt(st.nextToken());
            }
            //false : 1 (가능) / true : 0 (불가능)
            boolean flag = false;
            for(int i=0;i<6;i++){
                if(arr[i][0] + arr[i][1] + arr[i][2] != 5){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                search(0, 1);
            }
            sb.append(ans+" ");
        }
        System.out.println(sb);


    }

    private static void search(int me, int you) {
        if(ans == 1){
            return;
        }

        if(me == 5){
            ans = 1;
            return;
        }

        //내가 이겼을 때
        if(arr[me][0] > 0 && arr[you][2] > 0){
            arr[me][0]--;
            arr[you][2]--;
            if(you == 5){
                search(me+1, me+2);
            }else{
                search(me, you+1);
            }
            arr[me][0]++;
            arr[you][2]++;
        }

        //나와 무승부
        if(arr[me][1] > 0 && arr[you][1] > 0 ){
            arr[me][1]--;
            arr[you][2]--;
            if(you == 5){
                search(me+1, me+2);
            }else
                search(me, you+1);
            arr[me][1]++;
            arr[you][2]++;
        }

        //내가 졌을 때
        if(arr[me][2] > 0 && arr[you][0] > 0){
            arr[me][2]--;
            arr[you][0]--;
            if(you == 5){
                search(me+1, me+2);
            }else{
                search(me, you+1);
            }
            arr[me][2]++;
            arr[you][0]++;
        }

    }
}
