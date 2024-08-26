# 1. DFS

1) DFS란?

- 루트 노드에서 시작해서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법
- 넓게 탐색하기 전에 깊게 탐색하는 것이다 : depth-first search
- 모든 노드를 방문하고자 하는 경우에 이 방법을 쓴다

2) 특징

- 자기 자신을 호출하는 재귀 형태의 순환 알고리즘
- 전위 순회를 포함한 다른 형태의 트리 순회(후위, 중위) 순회는 모두 dfs의 한 종류이다
- 그래프 탐색 시, 어떤 노드를 방문했었는지 여부를 반드시 검사

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/05df5ba1-a25d-49a4-9e75-6f9fbf9a14a2/cc75f45f-2a47-446a-86ce-a6b45a66c8d9/image.png)

```java
public class 그래프탐색_01_DFS {
	static int N = 7;
	static int[][] adj = { 
			{ 0, 1, 1, 0, 0, 1, 0 }, 
			{ 1, 0, 0, 1, 0, 0, 1 }, 
			{ 1, 0, 0, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 1, 0, 0 }, 
			{ 0, 1, 0, 1, 1, 0, 0 } };
	
	static boolean[] visited = new boolean[N]; 
	
	public static void main(String[] args) {
		DFS(0);
	}
	
	static void DFS(int v) {
		visited[v] =true;
		System.out.println(v+1);

		for(int i=0;i<N;i++) {
			if(!visited[i] && adj[v][i]==1) {
				DFS(i);
			}
		}	
	}
}
```

# 2. BFS

1) BFS란?

- 루트 노드에서 시작해서 인접한 노드를 먼저 탐색하는 방법
- 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회방법
- 깊게 탐색하기 전에 넓게 탐색하는 것 (breadth-first search)
- 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때

2) 특징

- 시작 노드에서 시작해서 거리에 따라 단계별로 탐색한다고 볼 수 있다.
- 재귀적으로 동작하지 않음
- 방문여부 반드시 체크!
- 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 자료구조인 큐를 사용 - 선입선출
- 프림이나 다익스트라와 유사하다.

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/05df5ba1-a25d-49a4-9e75-6f9fbf9a14a2/4d095900-5042-4550-be12-d1338bc097a4/image.png)

```java
import java.util.LinkedList;
import java.util.Queue;

public class 그래프탐색_02_BFS {
	static int N = 7;
	static int[][] adj = { 
			{ 0, 1, 1, 0, 0, 1, 0 }, 
			{ 1, 0, 0, 1, 0, 0, 1 }, 
			{ 1, 0, 0, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 1, 0, 0 }, 
			{ 0, 1, 0, 1, 1, 0, 0 } };
	
	static boolean[] visited = new boolean[N];
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) {
		BFS(0); 
	}
	

	static void BFS(int v) {
		queue.add(v);
		visited[v] = true; 
		while(!queue.isEmpty()) 
			int t = queue.poll();
			System.out.println(t+1);
				for(int i=0;i<adj.length;i++) {
				if(!visited[i] && adj[t][i] == 1) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
```

# 3. 시간복잡도

1) 개념

- 입력값과 연산 수행 시간의 상관관계

2) 빅오표기법

- 최악의 상황일 때 걸리는 시간
- 자료의 수가 증가함에 따라 소요되는 처리시간 증가율을 그래프로 나타낸 것
- 빨간색 영역에 가까워질수록 수행 시간이 굉장히 오래 걸리는 알고리즘
- 초록색에 가까워질수록 수행 시간이 짧은 알고리즘

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/05df5ba1-a25d-49a4-9e75-6f9fbf9a14a2/97001760-2444-4e67-acba-0249470edada/image.png)

2) O(n)

```java
for(int i=0;i<n;i++){
	System.out.println(n);
}
```

3) O(n^2)

```java
for(int i=0;i<n;i++){
	for(int j=0;j<n;j++){
		System.out.println(n*j);
	}
}
```

4) O(nm)

```java
for(int i=0;i<n;i++){
	for(int j=0;j<m;j++){
		System.out.println(n*m);
	}
}
```

5) O(2^ n)

```java
public static int pibo(int n){
	if(n==0) return 0;
	else if (n==1) return 1;
	return pibo(n-1) + pibo(n-2);
}
```

6) O(log n)

```java
public static int binarySeacrh(int[] num, int target, int low, int high) {
    int mid = (low + high) / 2;
		
    if(target == num[mid]) return mid;
    else if(target < num[mid]) return binarySeacrh(num, target, low, mid-1);
    else return binarySeacrh(num, target, mid+1, high);
}
```
