package 백준;

import java.io.*;
import java.util.*;

public class 스타트링크 {
	static int F, S, G, U, D, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		ans = -1;
		bfs(F, S, G, U, D);
		System.out.println(ans == -1 ? "use the stairs" : ans);
	}

	private static void bfs(int f, int s, int g, int u, int d) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		int[] dist = new int[f + 1];
		dist[s] = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == g) {
				ans = dist[cur] - 1;
				return;
			}
			
			if (cur + u <= f && dist[cur + u] == 0) {
				dist[cur + u] = dist[cur] + 1;
				q.add(cur + u);
			}

			if (cur - d > 0 && dist[cur - d] == 0) {
				dist[cur - d] = dist[cur] + 1;
				q.add(cur - d);
			}
		}
	}

}
