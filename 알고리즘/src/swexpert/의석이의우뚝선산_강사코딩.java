package swexpert;

import java.util.Scanner;

public class 의석이의우뚝선산_강사코딩 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] mountain = new int[N];

			for (int i = 0; i < N; i++) {
				mountain[i] = sc.nextInt();
			}

			int ans = 0;
			int st = 0, top = 0, bottom = 0;
			for (int i = 0; i < N; i++) {
				st = top = bottom = i;

				while (i + 1 < N && mountain[i] < mountain[i + 1])
					i++; // 오르막 구간
				top = i; // 오르막이 있었다면 i가 끝까지 올라갔을 거임.
				while (i + 1 < N && mountain[i] > mountain[i - 1])
					i--; // 내리막 구간
				bottom = i; //내리막의 끝이거나 배열이 끝났거나
				
				if(st < top && top < bottom) {
					ans += (top - st) * (bottom - top);
				}
				if(bottom + 1 < N)
					i--;
			}
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}

}
