package swexpert;

import java.io.*;
import java.util.StringTokenizer;

public class 최장경로_강사코딩2 {
	static int N, M;
	static int[][] adj;
	//어떤 방문체크상태로, 어떤 정점에 도달했는지.
	static int[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			adj = new int[N + 1][N + 1];
			memo = new int[1 << (N + 1)][N + 1];
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1;
				adj[b][a] = 1;
				
			}
			ans = 0;
			for(int i = 1; i <= N; i++) {
				ans = Math.max(ans, dfs(i, 1 << i));
			}
			System.out.println("#" + t + " " + ans);
		}
	}
	static int ans = 0;
    static int dfs(int v, int visited) {
        //이미 계산한 기억이 있다면 해당 값을 리턴
        if( memo[visited][v] != 0 )
            return memo[visited][v];
        
        //더이상 방문할 노드가 없으면 현재 방문하는 노드1개만이 남은 경로 이므로, 초기값 1
        int ret = 1;
        //모든 노드를 검사하며, 방문안한 노드가 있다면 재귀호출 하고, 해당 호출한 노드가 가지는 최장경로 값+1 중 최대값을 기억
        for(int i = 1; i <= N; i++) {
            if( adj[v][i] == 1 && (visited & (1 << i)) == 0) {
                ret = Math.max(ret, dfs(i, visited | (1 << i))+1);
            }
        }
        //계산된 현재상태의 남은 최장경로값을 기억
        memo[visited][v] = ret;
        return ret;
    }
}