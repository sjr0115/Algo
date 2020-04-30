package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 텀프로젝트 {
	static int n, cnt;
	static int[] arr;
	static boolean[] visited, finish;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			finish = new boolean[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			for (int i = 1; i <= n; i++) {
				if(!visited[i]) {
					dfs(i);
				}
			}
			System.out.println(n - cnt);
		}
	}

	private static void dfs(int start) {
		if(visited[start]) return;
		
		visited[start] = true;
		int next = arr[start];
		
		if(!visited[next]) {
			dfs(next);
		} else {
			if(!finish[next]) {
				cnt++;
				for (int i = next; i != start; i = arr[i]) {
					cnt++;
				}
			}
		}
		finish[start] = true;
	}

}
