package swexpert;

import java.util.*;

public class 보물상자비밀번호_강사코딩 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();//4의 배수, 8 <= N
			int K = sc.nextInt();
			String s = sc.next();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N / 4; i++) {
				int start = 0;
				int end = N / 4;
				for (int j = 0; j < 4; j++) {
					String hex = s.substring(start, end);
					int num = Integer.parseInt(hex, 16);
					if(!list.contains(num)) {
						list.add(num);
					}
					start = end;
					end += N / 4;
				}
				char c = s.charAt(N - 1);
				s = c + s.substring(0, N - 1);
			}
			Collections.sort(list);
			System.out.println("#" + t + " " + list.get(list.size() - K));
		}
		sc.close();
	}

}
