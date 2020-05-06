

import java.io.*;
import java.util.*;
 
public class Algo1_대전_05_서정렬 {
	static int N, time, total, one, four, ten, cnt;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for (int t = 1; t <= T; t++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		time = Integer.parseInt(st.nextToken());
    		total = N * time;
    		one = 0;
    		four = 0;
    		ten = 0;
    		cnt = Integer.MAX_VALUE;
    		
    		Queue<Dala> q = new LinkedList<Dala>();
    		q.add(new Dala(0, 0, 0, 0, 0));
    		
    		while(!q.isEmpty()) {
    			Dala cur = q.poll();
    			
    			if(cur.sum == total) {
    				if(cur.cnt < cnt) {
    					one = cur.one;
    					four = cur.four;
    					ten = cur.ten;
    					cnt = cur.cnt;
    				}
    				continue;
    			}
    			if(cur.cnt < cnt) {
    				if(cur.sum + 10 <= total) {
    					q.add(new Dala(cur.ten + 1, cur.one, cur.four, cur.cnt + 1, cur.sum + 10));
    				}
    				if(cur.sum + 100 <= total) {
    					q.add(new Dala(cur.ten, cur.one + 1, cur.four, cur.cnt + 1, cur.sum + 100));
    				}
    				if(cur.sum + 400 <= total) {
    					q.add(new Dala(cur.ten, cur.one, cur.four + 1, cur.cnt + 1, cur.sum + 400));
    				}
    			}
    		}
    		
    		sb.append("#" + t + " ");
    		if(cnt == Integer.MAX_VALUE) {
    			sb.append(-1);
    		} else {
    			sb.append(four + " " + one + " " + ten);
    		}
    		sb.append("\n");
		}
    	System.out.println(sb.toString());
    }
    
    static class Dala {
    	int ten, one, four, cnt, sum;

		public Dala(int ten, int one, int four, int cnt, int sum) {
			super();
			this.ten = ten;
			this.one = one;
			this.four = four;
			this.cnt = cnt;
			this.sum = sum;
		}
    }
}