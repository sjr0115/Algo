package 알골강의;

import java.util.Arrays;

public class LIS {

	public static void main(String[] args) {
		int[] a = {3, 2, 6, 4, 5, 1};
		int[] LIS = new int[a.length]; //i 번째 숫자를 마지막 글자로 사용할 경우의 최장 증가수열의 길이
		int[] path = new int[a.length]; // 경로 역추적을 하기 위해
		
		for (int i = 0; i < LIS.length; i++) {
			LIS[i] = 1; // 초기값(1개 짜리 수열)
			path[i] = -1; // 나의 앞의 수열 숫자의 index
			for (int j = 0; j < i; j++) {
				if(a[j] < a[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
					path[i] = j;
				}
			}
		}
		
		System.out.println(Arrays.toString(LIS));
		int maxLisIndex = 0;
		for (int i = 0; i < LIS.length; i++) {
			if(LIS[maxLisIndex] < LIS[i]) {
				maxLisIndex = i;
			}
		}
		
		System.out.println("최장증가수열의 길이 : " + LIS[maxLisIndex]);
		System.out.println(Arrays.toString(path));
		String result = "";
		for (int i = maxLisIndex; i != -1; i = path[i]) {
			result = a[i] + " " + result;
		}
		System.out.println(result);
	}

}
