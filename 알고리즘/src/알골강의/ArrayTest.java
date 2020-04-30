package 알골강의;

public class ArrayTest {

	public static void main(String[] args) {
		int[][] a = {{1, 2, 3},
				   {4, 5, 6},
				   {7, 8, 9}};
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(a[i][j] == 5) {
					System.out.print(a[i - 1][j + 1] + " ");
					System.out.print(a[i + 1][j + 1] + " ");
					System.out.print(a[i + 1][j - 1] + " ");
					System.out.print(a[i - 1][j - 1]);
					System.out.println();
					int[] di = {-1, 1, 1, -1};
					int[] dj = {1, 1, -1, -1};
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						System.out.print(a[ni][nj] + " ");
					}
				}
			}
		}
	}

}
