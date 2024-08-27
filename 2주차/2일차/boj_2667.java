package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int apartment;
    static int N;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int[][] arr;
    static List<Integer> home;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        home = new ArrayList<>();

        for(int i = 0; i<N; i++) {
            String line = br.readLine();
            for(int j = 0; j<N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && arr[i][j]==1){
                    apartment++; // 단지개수
                    int cnt = dfs(i, j);
                    home.add(cnt);
                }
            }


        }
        System.out.println(apartment);
        Collections.sort(home);
        for(int i=0;i<home.size();i++){
            System.out.println(home.get(i));
        }
    }

    private static int dfs(int r, int c) {
        visited[r][c] =true;
        int cnt = 1;

        for(int d=0;d<4;d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr>=0 && nc>=0 && nr<N && nc<N && !visited[nr][nc]){
                if(arr[nr][nc] == 1){
                    cnt+=dfs(nr, nc);
                }
            }

        }
        return cnt;

    }
}
