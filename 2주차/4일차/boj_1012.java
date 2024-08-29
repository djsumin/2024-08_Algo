package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0;tc<T;tc++) {
            int cnt = 0; //배추흰지렁이 개수
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로길이
            N = Integer.parseInt(st.nextToken()); //세로길이
            int K = Integer.parseInt(st.nextToken()); //배추가 심어져 있는 개수
            map = new int[N][M]; //밭
            visited = new boolean[N][M];
            for(int i = 0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        visited[i][j] = true;
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);
        }

    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        for(int d=0;d<4;d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]){
                if(map[nr][nc]==1){
                    dfs(nr, nc);
                }
            }
        }
    }
}
