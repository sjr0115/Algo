package 백준;

import java.io.*;
import java.util.*;

public class 낚시왕 {
	static int R, C, M, r, c, s, d, z, fish, time;
	static int[][] map, speed, dir;
	static int[] dy = {0, -1, 1, 0, 0 };
	static int[] dx = {0, 0, 0, 1, -1 };
	static ArrayList<Point> arr = new ArrayList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			arr.add(new Point(r, c, s, d, z));
		}
		fish = time = 0;
		solve();
		System.out.println(fish);
	}

	private static void solve() {
		
		while (time < C) {
			Collections.sort(arr);
			
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).x == time) {
					fish += arr.get(i).size;
					arr.remove(i);
					break;
				}
			}
			
			for (int i = 0; i < arr.size(); i++) {
				Point idx = arr.get(i);
				int y = idx.y;
				int x = idx.x;
				int dir = idx.dir;
				int speed = idx.speed;
				
				while(speed > 0) {
					y += dy[dir];
					x += dx[dir];
					
					if(y < 0 || x < 0 || y >= R || x >= C) {
						y -= dy[dir];
						x -= dx[dir];
						
						if(dir == 1) {
							dir = 2;
						} else if(dir == 2) {
							dir = 1;
						} else if(dir == 3) {
							dir = 4;
						} else if(dir == 4) {
							dir = 3;
						}
						continue;
					}
					speed--;
				}
				arr.get(i).setY(y);
				arr.get(i).setX(x);
				arr.get(i).setDir(dir);
			}
			
			map = new int[R][C];
			speed = new int[R][C];
			dir = new int[R][C];
			
			for (int i = 0; i < arr.size(); i++) {
				int y = arr.get(i).y;
				int x = arr.get(i).x;
				
				if(map[y][x] == 0) {
					map[y][x] = arr.get(i).size;
					speed[y][x] = arr.get(i).speed;
					dir[y][x] = arr.get(i).dir;
				} else {
					if(map[y][x] < arr.get(i).size) {
						map[y][x] = arr.get(i).size;
						speed[y][x] = arr.get(i).speed;
						dir[y][x] = arr.get(i).dir;
					}
				}
			}
			
			arr.clear();
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] != 0) {
						arr.add(new Point(i, j, speed[i][j], dir[i][j], map[i][j]));
					}
				}
			}
			time++;
		}
	}

	static class Point implements Comparable<Point> {
		int y, x, speed, dir, size;

		public Point(int y, int x, int speed, int dir, int size) {
			super();
			this.y = y;
			this.x = x;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getSpeed() {
			return speed;
		}

		public void setSpeed(int speed) {
			this.speed = speed;
		}

		public int getDir() {
			return dir;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x) {
				if (this.y == o.y) {
					return o.size - this.size;
				} else {
					return this.y - o.y;
				}
			}
			return this.x - o.x;
		}
	}
}
