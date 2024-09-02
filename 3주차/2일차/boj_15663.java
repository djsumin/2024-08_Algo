import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	// 순열
	static int N;
	static int M;
	static int[] arr; // 배열
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// n개중에 M개를 뽑자 먼저.
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		// 중복제거하는 방법
//		arr = Arrays.stream(arr).distinct().toArray();
//		System.out.println(Arrays.toString(arr));
		permutation(0);
		bw.write(sb.toString());
		bw.close();
	}

	private static void permutation(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		//바로 직전에 했던 아이..
		int before = 0; //변수초기화!!!
		for (int i = 0; i < arr.length; i++) {
			if (visited[i])
				continue;
			//중복없애주기
			//바로 직전값이랑 같은지 안같은 지 확인!
			if (before != arr[i]) {
				visited[i] = true;
				result[cnt] = arr[i];
				before = arr[i];
				permutation(cnt + 1);
				visited[i] = false;
			}
		}
	}

}
