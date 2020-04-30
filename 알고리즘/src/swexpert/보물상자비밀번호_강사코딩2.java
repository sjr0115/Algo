package swexpert;

import java.util.*;

public class 보물상자비밀번호_강사코딩2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 4의 배수, 8 <= N
			int K = sc.nextInt();
			String s = sc.next();
			String t = s + s.substring(0, N / 4 - 1);
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				String hex = t.substring(i, i + N / 4);
				int num = Integer.parseInt(hex, 16);
				if (!list.contains(num)) {
					list.add(num);
				}
			}
			Collections.sort(list, Collections.reverseOrder());
			System.out.println("#" + tc + " " + list.get(K - 1));
		}
		sc.close();
	}

}
