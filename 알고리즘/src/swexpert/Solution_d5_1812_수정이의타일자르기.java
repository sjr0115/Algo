package swexpert;

import java.io.*;
import java.util.*;

public class Solution_d5_1812_수정이의타일자르기 {
	static int N, M, size[], cnt; 
	static PriorityQueue<Point> pq = new PriorityQueue<Point>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			size = new int[N];
			for (int i = 0; i < N; i++) {
				size[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			pq.add(new Point(M, M));
			cut();
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	private static void cut() {
		cnt++;
		Arrays.sort(size);
		for (int i = N - 1; i >= 0; i--) {
			go(1 << size[i]);
		}
	}

	private static void go(int size) {
		Point p = pq.poll();
		if(p.min >= size) {
			pq.offer(new Point(p.min - size, size));
			pq.offer(new Point(p.max, p.max - size));
		} else {
			pq.offer(p);
			pq.offer(new Point(M - size, size));
			pq.offer(new Point(M, M - size));
			cnt++;
		}
	}

	static class Point implements Comparable<Point> {
		int max, min;

		public Point(int width, int height) {
			if(width < height) {
				min = width;
				max = height;
			} else {
				min = height;
				max = width;
			}
		}

		@Override
		public int compareTo(Point o) {
			return o.min - o.min;
		}
		
	}
}
