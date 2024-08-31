package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            String line = sc.nextLine();
            for(int j=0;j<m;j++){
                map[i][j] = line.charAt(j)-'0';
            }
        }//입력끝

        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(map[n-1][m-1]);


    }

    private static void bfs(int r, int c) {
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{r,c});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int d= 0;d<4;d++){
                int nr = x + dr[d];
                int nc = y + dc[d];
                if(nr >= 0 && nc >=0&& nr<n && nc<m){
                    if(!visited[nr][nc] && map[nr][nc]==1){
                        q.add(new int[]{nr,nc});
                        visited[nr][nc] = true;
                        map[nr][nc] = map[x][y] + 1; //값이 계속 늘어나게.
                    }
                }
            }
        }
    }
}
