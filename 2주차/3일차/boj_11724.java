package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        list = new ArrayList[n+1];

        for(int i=1;i<n+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); //시작점
            int e = Integer.parseInt(st.nextToken()); //끝점
            list[s].add(e);
            list[e].add(s);
        }

        int cnt = 0; //연결요소의 개수

        for(int i=1;i<n+1;i++){
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int num) {
        if(visited[num]){
            return;
        }
        visited[num] = true;
        for(int i : list[num]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}
