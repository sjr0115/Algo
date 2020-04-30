package 알골강의;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
/*
7 11
0 1 2
0 2 2
0 5 8
1 2 1
1 3 19
2 5 5
3 4 7
3 5 11
3 6 15
4 5 9
4 6 3
*/
   static int[] parents;
   static int[] rank;
   // 입력은 첫줄에 정점 갯수 / 간선 갯수
   // 그 다음 간선의 정보 : 정점 1 / 정점 2 / 가중치 * 간선 갯수

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int V = sc.nextInt();
      int E = sc.nextInt();
      int[][] edges = new int[E][3];
      parents = new int[V];
      rank = new int[V];
      for (int e = 0; e < E; e++) {
         edges[e][0] = sc.nextInt(); // from
         edges[e][1] = sc.nextInt(); // to
         edges[e][2] = sc.nextInt(); // weight
      }
      // 간선들 가중치 오름차순 정렬
      Arrays.sort(edges, new Comparator<int[]>() {

         @Override
         public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[2], o2[2]);
         }
      });
      for(int v=0; v<V; v++) {
         makeSet(v);
      }
      int result = 0;
      int cnt = 0;
      for(int e=0; e<E; e++) {
         int from = findSet(edges[e][0]);
         int to = findSet(edges[e][1]);
         if(from == to) {
            continue;
         }
         union(from, to);
         //간선 선택
         result += edges[e][2];
         // 정점 갯수 -1번 반복
         cnt++;
         if(cnt == V-1) {
            break;
         }
      }
      System.out.println(result);
      // 간선이 연결하는 두 정점이 같은 팀이 아니면
      // 한팀으로 만들고 그 간선 선택
      // 같은 팀이면 통과

   }

   static void makeSet(int x) {
      parents[x] = x;
   }
   
   static int findSet(int x) {
      if (x == parents[x]) {
         return x;
      } else {
         parents[x] = findSet(parents[x]);
         return parents[x];
      }
   }

   static void union(int x, int y) {
      int px = findSet(x);
      int py = findSet(y);
      if (rank[px] > rank[py]) {
         parents[py] = px;
      } else {
         parents[px] = py;
         if (rank[px] == rank[py]) {
            rank[py]++;
         }
      }
   }
}