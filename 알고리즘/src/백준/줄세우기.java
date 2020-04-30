package 백준;

import java.io.*;
import java.util.*;

public class 줄세우기 {

	static int N, M;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new List[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		int[] cnt = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			list[u].add(v);
			cnt[v]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			if(cnt[i] == 0) {
				q.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + 1).append(" ");
			
			for (int i = 0; i < list[cur].size(); i++) {
				int next = list[cur].get(i);
				cnt[next]--;
				if(cnt[next] == 0) {
					q.add(next);
				}
			}
		}
		System.out.println(sb);
	}

}
