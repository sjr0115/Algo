package 백준;

import java.io.*;
import java.util.*;

public class 숨바꼭질4 {
	static int N, K;
	static int[] visited;
	static int[] path;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		path = new int[100001];
		visited[N] = 1;
		path[N] = N;
		bfs(N, K);
	}
	private static void bfs(int N, int K) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == K) {
				System.out.println(visited[K] - 1);
				
				Stack<Integer> stack = new Stack<>();
				while(path[cur] != cur) {
					stack.add(cur);
					cur = path[cur];
				}
				stack.add(N);
				
				StringBuilder sb = new StringBuilder();
				while(!stack.isEmpty()) {
					sb.append(stack.pop() + " ");
				}
				System.out.println(sb.toString());
				return;
			}
			if(cur * 2 <= 100000 && visited[cur * 2] == 0) {
				visited[cur * 2] = visited[cur] + 1;
				path[cur * 2] = cur;
				q.add(cur * 2);
			}
			
			if(cur + 1 <= 100000 && visited[cur + 1] == 0) {
				visited[cur + 1] = visited[cur] + 1;
				path[cur + 1] = cur;
				q.add(cur + 1);
			}
			
			if(cur - 1 >= 0 && visited[cur - 1] == 0) {
				visited[cur - 1] = visited[cur] + 1;
				path[cur - 1] = cur;
				q.add(cur - 1);
			}
		}
	}

}
