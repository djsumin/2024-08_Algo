import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] visited;
	static int [][] adjArr;
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//정점
		int M = Integer.parseInt(st.nextToken());//간선
		int V = Integer.parseInt(st.nextToken());//탐색시작점
		adjArr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjArr[a][b]=1;
			adjArr[b][a]=1;
		}//입력받기
//		System.out.println(Arrays.deepToString(adjArr));
		DFS(V);
		visited = new boolean[N+1]; //방문배열 초기화
		System.out.println();
		BFS(V);
	}
	
	 static void BFS(int i) {
		 queue.add(i);
		 visited[i] = true;
		 while(!queue.isEmpty()) {
			 int t = queue.poll();
			 System.out.print(t +" ");
			 for(int j =1 ;j<adjArr.length;j++) {
				 if(!visited[j] && adjArr[t][j] ==1) {
					 queue.add(j);
					 visited[j]=true;
				 }
			 }
		 }
	}
	 
	static void DFS(int i) {
		visited[i]=true;
		System.out.print(i+" ");
		
		for(int a=1;a<N+1;a++) {
			if(!visited[a] && adjArr[i][a]==1) {
				DFS(a);
			}
		}
	}
	
}
