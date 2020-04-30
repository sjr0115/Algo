package swexpert;

import java.util.*;


public class 염라대왕이름정렬_강사코딩2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			
			String[] name = new String[N];
			for (int i = 0; i < N; i++) {
				name[i] = sc.next();
			}
			
			Arrays.sort(name, new Comparator<String>() {
				@Override
				public int compare(String pre, String next) {
					if(pre.length() != next.length()) {
						return pre.length() - next.length();
					} else {
						return pre.compareTo(next);
					}
				}
				
			});
			
			System.out.println("#" + t + " ");
			String temp = null;
			for (int i = 0; i < name.length; i++) {
				if(!name[i].equals(temp)) {
					System.out.println(name[i]);
				}
				temp = name[i];
			}
		}
		sc.close();
	}
}
