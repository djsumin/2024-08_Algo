# 💡**문제 분석 요약**

미로에서 1,1 에서 n,m 까지 가는 최단 거리의 칸 수를 세는 문제
bfs를 통해 최단거리 문제 구하기

# 💡**알고리즘 설계**

1. 처음 좌표 0,0 을 방문처리해주고 시작점으로부터 bfs 탐색 시작
2. 사방탐색 + 누적 거리를 계속해서 배열에 넣어주자.


  
# 💡코드

```java
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
```

# 💡시간복잡도

# 💡 틀린 이유
접근 방식이 틀렸다.
cnt를 계수하는 방법으로 풀이하려고 했지만, 그것보다는 map 자체에 누적해서 값을 더해주는 것이 올바른 접근 방식인 것 같다

# 💡 틀린 부분 수정 or 다른 풀이
  ```java
  것이다! 아래 조건처럼 말이다.
// 거리 계산하는 배열(dist)을 -1로 값을 세팅 해둘 것이기 때문에 이미 값이 있다면 PASS!
if( miro[i][j] == 0 || dist[i][j] != -1 ){
	continue;
}
    

    

 
🖥 전체 코드
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      char[][] miro = new char[N][M];  // 미로를 저장할 배열
      int[][] dist = new int[N][M];    // 거리를 계산할 dist 배열
      int[] dx = {1, 0 , -1, 0};       // 상하좌우 계산할 x좌표
      int[] dy = {0, 1, 0, -1};        // 상하좌우 계산할 y좌표
      Queue<Pair> qu = new LinkedList<>();
      
      for(int i=0; i<N; i++){
          String line = bf.readLine();
          for(int j=0; j<M; j++){
              miro[i][j] = line.charAt(j);
              dist[i][j] = -1;    // 거리를 -1로 세팅하면, 방문여부를 확인가능.
          }
      }
      
      qu.offer(new Pair(0,0));  // 시작점
      dist[0][0] = 0;   // 첫 시작이니까 거리가 0이다.
      
      while(!qu.isEmpty()){
          Pair p = qu.poll();
          
          // 상, 하, 좌, 우를 계산해준다.
          for(int i=0; i<4; i++){
            int nX = p.x + dx[i];
            int nY = p.y + dy[i];
            
            // 벽에 부딪히거나, 범위를 넘어가면 PASS
            if(nX < 0 || nX >= N || nY < 0 || nY >= M){
                continue;
            }
            // 길이 아니거나, 방문을 했다면 PASS
            if(miro[nX][nY] == '0' || dist[nX][nY] != -1){
                continue;
            }
            
            // 큐에 이동한 좌표를 넣어준다.
            qu.offer(new Pair(nX, nY));
            // 한칸 이동하였기 때문에, 이전 출발지점의 거리 +1을 해준다.
            dist[nX][nY] = dist[p.x][p.y] + 1;
          }
      }
      
      // 마지막 지점의 (거리 + 1)를 출력해주면 된다.
      System.out.print(dist[N-1][M-1] + 1);
    }
    
    // 큐에 좌표를 넣어주기 위한 클래스
    public static class Pair{
        int x, y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
    }
}
출처: https://iseunghan.tistory.com/312 [iseunghan:티스토리]
  ```

# 💡 느낀점 or 기억할정보
- bfs가 dfs보다 살짝 취약하고 응용문제에 약한 것 같다. bfs 응용문제도 많이 풀어바야겠다
  
