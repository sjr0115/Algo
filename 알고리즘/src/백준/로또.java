package 백준;

import java.io.*;
import java.util.StringTokenizer;

public class 로또 {
	static int[] S;
	static int k;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			S = new int[k];
			visited = new boolean[k];
			
			if(k == 0) break;
			
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			System.out.println();
			
		}
	}
	
	private static void dfs(int cnt, int idx) {
		StringBuilder sb = new StringBuilder();
		if(cnt == 6) {
			for (int i = 0; i < k; i++) {
				if(visited[i]) {
					sb.append(S[i]).append(" ");
				}
			}
			sb.append("\n");
			System.out.print(sb);
			return;
		}
		for (int i = idx; i < k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}

}
