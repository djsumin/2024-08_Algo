package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K;
    static boolean[] visited;
    static class Pos{
        int num;
        int time;

        public Pos(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수빈위치
        K = Integer.parseInt(st.nextToken()); //동생위치

        if(N == K){
            System.out.println(0);
        }else{
            bfs(N);
        }


    }

    private static void bfs(int num) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(num, 0));
        visited = new boolean[100001];
        visited[num] = true;

        while(!q.isEmpty()){
            Pos cur = q.poll();

            //종료조건
            if(cur.num + 1 == K || cur.num - 1 ==K || K == 2 * cur.num){
                System.out.println(cur.time + 1);
                return;
            }
            if(cur.num + 1 < 100001 && !visited[cur.num + 1]){
                visited[cur.num + 1] = true;
                q.add(new Pos(cur.num + 1, cur.time+ 1));
            }
            if(cur.num-1 >= 0 && !visited[cur.num-1]){
                visited[cur.num-1] = true;
                q.add(new Pos(cur.num-1, cur.time + 1));
            }
            if(cur.num * 2 < 100001 && !visited[cur.num*2]){
                visited[cur.num*2] = true;
                q.add(new Pos(cur.num*2, cur.time + 1));
            }
        }
    }
}
