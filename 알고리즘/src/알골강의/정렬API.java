package 알골강의;

import java.util.*;

public class 정렬API {

	public static void main(String[] args) {
		int[] a = {3, 1, 5, 4, 2};
		Arrays.sort(a); // 배열의 원소를 정렬, DualPrivotQuicksort, 기본형 타입
		
		Integer[] b = {3, 1, 5, 4, 2};
		Arrays.sort(b); // 타입과 개수에 따라 다른 정렬방법이 실행된다
		System.out.println(Arrays.toString(b));
		
		Arrays.sort(b, Comparator.reverseOrder()); //역순으로 정렬
		System.out.println(Arrays.toString(b));
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(3);
		l.add(5);
		l.add(1);
		l.add(2);
		Collections.sort(l);
		l.sort(null);
		
	}

}
