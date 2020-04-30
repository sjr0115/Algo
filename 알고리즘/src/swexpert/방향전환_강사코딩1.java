package swexpert;

import java.io.*;
import java.util.*;

public class 방향전환_강사코딩1 {
	static class Point {
		int y, x, cnt;
		boolean dir;

		public Point(int y, int x, int cnt, boolean dir) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
		}
	}

	static int sy, sx, fy, fx;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sy = Integer.parseInt(st.nextToken()) + 100;
			sx = Integer.parseInt(st.nextToken()) + 100;
			fy = Integer.parseInt(st.nextToken()) + 100;
			fx = Integer.parseInt(st.nextToken()) + 100;

			// BFS탐색을 위한 Queue자료구조를 준비
			Queue<Point> queue = new LinkedList<>();
			// 방문체크를 위한 방문체크 변수를 준비
			boolean[][][] visited = new boolean[201][201][2];
			// 시작점을 큐에 삽입
			queue.add(new Point(sy, sx, 0, true)); //가로
			queue.add(new Point(sy, sx, 0, false)); //세로
			// 첫 시작점을 현재 위치로, 다음 이동을 가로로 이동할 수 있는 상태
			// 첫 시작점을 현재 위치로, 다음 이동을 세로로 이동할 수 있는 상태
			// 큐에 이미 삽입된 상태에 대해서는 방문체크
			visited[sy][sx][0] = true;
			visited[sy][sx][1] = true;
			// 큐가 빌때까지 상태를 탐색
			while (!queue.isEmpty()) {
				Point p = queue.poll();
				// 현재 도달한 상태의 좌표가 목적지라면 종료
				if (p.y == fy && p.x == fx) {
					System.out.println("#" + t + " " + p.cnt);
					break;

				}
				if (p.dir) {
					// 현재 자신의 방향이 가로로 허용된 경우
					// 두가지 세로이동에 대해서 유효하다면(범위체크, 방문체크), 상태노드를 큐에 추가 후 방문 체크
					for (int d = 0; d < 2; d++) {
						int ny = p.y + dy[d];
						int nx = p.x + dx[d];
						if (ny < 0 || ny > 200 || nx < 0 || nx > 200)
							continue;
						if (visited[ny][nx][0])
							continue;
						queue.add(new Point(ny, nx, p.cnt + 1, !p.dir));
						visited[ny][nx][0] = true;
					}

				} else {
					// 현재 자신의 방향이 세로로 허용된 경우
					// 두가지 가로 이동에 대해서 유효하다면, 상태노드를 큐에 추가 후 방문체크
					// 세로 허용
					for (int d = 2; d < 4; d++) {
						int ny = p.y + dy[d];
						int nx = p.x + dx[d];
						if (ny < 0 || ny > 200 || nx < 0 || nx > 200)
							continue;
						if (visited[ny][nx][1])
							continue;
						queue.add(new Point(ny, nx, p.cnt + 1, !p.dir));
						visited[ny][nx][1] = true;
					}
				}
			}
		}
	}

}
