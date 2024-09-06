
package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int l, c;
    static boolean[] visited;
    static String[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new String[c];
        for(int i=0;i<c;i++){
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        //c개 중에 l개뽑기
        comb(0, 0, new boolean[c]);

    }

    private static void comb(int start, int depth, boolean[] visited) {
        if(depth == l){
            print(arr, visited);
            return;
        }
        for(int i=start;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                comb(i+1, depth+1, visited);
                visited[i] = false;
            }
        }
    }

    private static void print(String[] arr, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        if(check(arr, visited)){
            for(int i=0;i<arr.length;i++){
                if(visited[i]){
                    sb.append(arr[i]);
                }
            }

        }else{
            return;
        }

        System.out.println(sb);
    }

    private static boolean check(String[] arr, boolean[] visited) {
        int ja = 0; // 자음
        int mo = 0; // 모음
        for(int i=0;i<arr.length;i++){
            if(visited[i]){
                if(arr[i].contains("a") || arr[i].contains("i") || arr[i].contains("e") || arr[i].contains("o") || arr[i].contains("u")){
                    mo++;
                }else{
                    ja++;
                }
            }
        }
        if(ja>=2 && mo>=1){
            return true;
        }
        return false;
    }
}
