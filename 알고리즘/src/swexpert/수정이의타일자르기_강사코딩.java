package swexpert;

import java.io.*;
import java.util.*;

public class 수정이의타일자르기_강사코딩 {
	
	static class Rectangle implements Comparable<Rectangle> {
		
		int min, max;
		
		public Rectangle(int width, int height) {
			if(width < height) {
				min = width;
				max = height;
			} else {
				min = height;
				max = width;
			}
		}

		@Override
		public int compareTo(Rectangle o) {
			return o.min - this.min;
		}
		
	}
	
	static int N, M, size[], cnt;
	static PriorityQueue<Rectangle> queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			size = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				size[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			sb.append("#").append(t).append(" ");
			cut();
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
	private static void cut() {
		//가장 큰 크기의 정사각형부터 만들기
		Arrays.sort(size);
		queue = new PriorityQueue<Rectangle>();
		queue.offer(new Rectangle(M, M));
		cnt++;
		for (int i = N - 1; i >= 0; i--) {
			go(1 << size[i]);
		}
	}
	private static void go(int size) {
		//직사각형의 최소변의 길이가 size보다 같거나 크면 원하는 크기의 정사각형을 만들 수 있음
		Rectangle r = queue.poll();
		if(r.min >= size) {
			queue.offer(new Rectangle(r.min - size, size));
			queue.offer(new Rectangle(r.min, r.max - size));
		}else {
			// 아니면 원하는 크기의 정사각형을 만들 수 없음
			queue.offer(r);
			queue.offer(new Rectangle(M - size, size));
			queue.offer(new Rectangle(M, M - size));
			cnt++;
		}
		
	}

}
